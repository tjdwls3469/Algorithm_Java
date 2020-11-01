import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon4963_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int w, h, ans;
		String line;
		
		boolean[][] map = new boolean[50][50];
		boolean[][] check = new boolean[50][50];
		
		int[] dx = new int[] {0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] qx = new int[2500];
		int[] qy = new int[2500];
		int frontX, rearX, frontY, rearY;
		int fx, fy, nx, ny;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			for (int i = 0; i < h; i++) {
				line = br.readLine();
				for (int j = 0, index = 0; j < w; j++, index += 2) {
					if('1' == line.charAt(index)) {
						map[i][j] = true;
					}else {
						map[i][j] = false;
					}
				}
			}
			
			for (int i = 0; i < h; i++) {
				Arrays.fill(check[i], 0, w, false);
			}
			
			ans = 0;
			frontX = rearX = frontY = rearY = -1;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] && !check[i][j]) {
						ans++;
						
						//BFS
						check[i][j] = true;
						qx[++rearX] = i;
						qy[++rearY] = j;
						
						while(frontX != rearX) {
							fx = qx[++frontX];
							fy = qy[++frontY];
							
							for (int k = 0; k < dx.length; k++) {
								nx = fx + dx[k];
								ny = fy + dy[k];
								
								if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] && !check[nx][ny]) {
									check[nx][ny] = true;
									qx[++rearX] = nx;
									qy[++rearY] = ny;
								}
							}
						}
					} // end of if
				}
			} // end of 탐색
			sb.append(ans).append('\n');
		} // end of while
		System.out.print(sb);
	}
}
