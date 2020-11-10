import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1012 {
	public static boolean[][] map = new boolean[50][50];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int M, N, K, X, Y;
		int ans;
		
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		int[] qx = new int[2500];
		int[] qy = new int[2500];
		int frontX, rearX, frontY, rearY;
		int fx, fy, nx, ny;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				
				map[Y][X] = true;
			}
			
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]) {
						ans++;
						frontX = rearX = frontY = rearY = -1;
						// BFS
						map[i][j] = false;
						qx[++rearX] = i;
						qy[++rearY] = j;
						
						while(frontX != rearX) {
							fx = qx[++frontX];
							fy = qy[++frontY];
							
							for (int k = 0; k < dx.length; k++) {
								nx = fx + dx[k];
								ny = fy + dy[k];
								
								if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny]) {
									map[nx][ny] = false;
									qx[++rearX] = nx;
									qy[++rearY] = ny;
								}
							}
						}
					}
				}
			} // ene of for
			sb.append(ans).append('\n');
		} // end of while
		System.out.print(sb);
	} // end of main
}
