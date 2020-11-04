import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2239 {
	public static int[][] map;
	public static boolean[][] checkRow;
	public static boolean[][] checkCol;
	public static boolean[][] checkRectangle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		String line;
		
		checkRow = new boolean[9][10];
		checkCol = new boolean[9][10];
		checkRectangle = new boolean[9][10];
		int zeroCnt = 0;
		
		for (int i = 0; i < 9; i++) {
			line = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j) - '0';
				if(map[i][j] == 0) {
					zeroCnt++;
					continue;
				}
				
				checkRow[i][map[i][j]] = true;
				checkCol[j][map[i][j]] = true;
				checkRectangle[(i/3)*3 + (j/3)][map[i][j]] = true;	// rectangleNum = (x/3)*3 + (y/3)
			}
		}
		
		solve(0, 0, zeroCnt);
	}
	
	public static void solve(int x, int y, int cnt) {
		if(cnt == 0) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			
			System.out.print(sb);
			System.exit(0);
		}
		
		if(y==9) {
			x++;
			y = 0;
		}
		
		if(map[x][y] != 0) {
			solve(x, y+1, cnt);
			return;
		}
		
		int rectangleNum = (x/3)*3 + (y/3);
		
		for (int k = 1; k <= 9; k++) {
			// 숫자 중복이 없으면
			if(!checkRow[x][k] && !checkCol[y][k] && !checkRectangle[rectangleNum][k]) {
				checkRow[x][k] = checkCol[y][k] = checkRectangle[rectangleNum][k] = true;
				map[x][y] = k;
				solve(x, y+1, cnt-1);
				checkRow[x][k] = checkCol[y][k] = checkRectangle[rectangleNum][k] = false;
				map[x][y] = 0;
			}
		}
	}
}
