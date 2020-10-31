import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2667 {
	public static int N;
	public static String[] map;
	public static int homeCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N];
		
		int size = N * N;
		check = new boolean[N][N];
		qx = new int[size];
		qy = new int[size];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		
		int groupCnt = 0;
		int[] homeAray = new int[size];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if('1' == map[i].charAt(j) && !check[i][j]) {
					homeCnt = 1;
					bfs(i, j);
					homeAray[groupCnt++] = homeCnt;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(groupCnt).append('\n');
		
		Arrays.sort(homeAray, 0, groupCnt);
		for (int i = 0; i < groupCnt; i++) {
			sb.append(homeAray[i]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static int[] dx = new int[] {0, -1, 0, 1};
	public static int[] dy = new int[] {-1, 0, 1, 0};
	public static boolean[][] check;
	public static int[] qx;
	public static int[] qy;
	public static int frontX, frontY, rearX, rearY;
	public static int fx, fy, nx, ny;

	public static void bfs(int x, int y) {
		frontX = frontY = rearX = rearY = -1;
		
		check[x][y] = true;
		qx[++rearX] = x;
		qy[++rearY] = y;
		
		while(frontX != rearX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && '1' == map[nx].charAt(ny) && !check[nx][ny]) {
					check[nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					homeCnt++;
				}
			}
		}
	}
}
