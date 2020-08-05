import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4963 {
	public static int[][] map = new int[50][50];
	public static boolean[][] check = new boolean[50][50];
	public static int col;
	public static int row;
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			if(row == 0 && col == 0) {
				break;
			}
			
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}	// map 초기화 OK
			
//			for (int i = 0; i < row; i++) {
//				String str = br.readLine();
//				for (int j = 0, index = 0; j < col; index += 2) {
//					map[i][j] = str.charAt(index);
//				}
//			}
			
			ans = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(map[i][j] == 1 && !check[i][j]) {
						ans++;
						dfs(i,j);
					}
				}
			}
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					check[i][j] = false;
				}
			}

			sb.append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int nx = 0;
	public static int ny = 0;

	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for (int i = 0; i < dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == 1 && !check[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
}
