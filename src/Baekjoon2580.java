import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2580 {
	public static int[][] map = new int[9][9];
	public static boolean[][] row = new boolean[9][10];		// 행, 숫자 존재 유무
	public static boolean[][] col = new boolean[9][10];		// 열, 숫자 존재 유무
	public static boolean[][] square = new boolean[9][10];	// 사각형, 숫자 존재 유무
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					square[i/3*3+j/3][map[i][j]] = true;	// i/3*3+j/3 : 0~8까지 사각형 칸을 나타냄
				}
			}
		}
		solve(0);
	}	// end of main
	
	public static StringBuilder ans = new StringBuilder();
	
	public static void solve(int cnt) {
		if (cnt == 81) {
	        for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					ans.append(map[i][j]).append(' ');
				}
				ans.append('\n');
			}
	        System.out.print(ans);
	        System.exit(0);
	    }
		
		int x = cnt / 9;	// (0,0) ~ (8,8) 총 81칸 
		int y = cnt % 9;
		if(map[x][y] != 0) {
			solve(cnt + 1);
			return;
		}else {
		 	for (int i = 1; i <= 9; i++) {
				if(!row[x][i] && !col[y][i] && !square[x/3*3+y/3][i]) {		// 행, 열, 사각형에 없는 숫자라면
					row[x][i] = col[y][i] = square[x/3*3+y/3][i] = true;
					map[x][y] = i;
					
					solve(cnt + 1);
					map[x][y] = 0;		// 넣은 값이 정답이 아닐수도 있으니 다시 원상태로
					row[x][i] = col[y][i] = square[x/3*3+y/3][i] = false;
				}
			}
		}
	}	// end of solve
}
