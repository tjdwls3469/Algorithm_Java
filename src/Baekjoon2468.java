import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2468 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		boolean[][] check = new boolean[N][N];
		StringTokenizer st;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] < min) {
					min = map[i][j];
				} else if(map[i][j] > max) {
					max = map[i][j];
				}
			}
		}	// map 초기화 OK
		
		int size = N * N;
		int[] qx = new int[size];
		int[] qy = new int[size];
		int frontX, rearX, frontY, rearY;
		int fx, fy, nx, ny;
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		int ans = 1;
		int safetyArea = 0;
		for (int rain = min; rain < max; rain++) {
			safetyArea = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// BFS, 내린 비의 양 : rain
					if(map[i][j] > rain && !check[i][j]) {
						safetyArea++;
						frontX = frontY = rearX = rearY = -1;
						
						check[i][j] = true;
						qx[++rearX] = i;
						qy[++rearY] = j;
						
						while(rearX != frontX) {
							fx = qx[++frontX];
							fy = qy[++frontY];
							
							for (int k = 0; k < dx.length; k++) {
								nx = fx + dx[k];
								ny = fy + dy[k];
								
								if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > rain && !check[nx][ny]) {
									check[nx][ny] = true;
									qx[++rearX] = nx;
									qy[++rearY] = ny;
								}
							}
						}
					}	// end of BFS
				}
			}	// map 순회 끝
			
			// chaek 배열 초기화
			for (int k = 0; k < N; k++) {
				Arrays.fill(check[k], false);
			}
			
			if(safetyArea > ans) {
				ans = safetyArea;
			}
		}	// end of for (rain)
		System.out.println(ans);
	}	// end of main
}
