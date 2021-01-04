import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10026 {
	public static String[] map = new String[100];
	public static int rc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		rc = Integer.parseInt(br.readLine());

		for (int i = 0; i < rc; i++) {
			map[i] = br.readLine();
		} // map 초기화 OK

		int rgb = 0;
		for (int i = 0; i < rc; i++) {
			for (int j = 0; j < rc; j++) {
				if(!check[i][j]) {
					rgb++;
					RGB(i,j);
				}
			}
		}
		
		for (int i = 0; i < rc; i++) {
			Arrays.fill(check[i], 0, rc, false);
		}
		
		int b = 0;
		for (int i = 0; i < rc; i++) {
			for (int j = 0; j < rc; j++) {
				if(!check[i][j]) {
					b++;
					B(i,j);
				}
			}
		}
		System.out.println(rgb + " " + b);
	} // end of main

	public static boolean[][] check = new boolean[100][100];
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int[] qx = new int[10000];
	public static int[] qy = new int[10000];
	public static int frontX, rearX, frontY, rearY;
	public static int fx, fy, nx, ny;

	public static void RGB(int x, int y) {
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
				
				if(nx >= 0 && nx < rc && ny >= 0 && ny < rc && map[nx].charAt(ny) == map[fx].charAt(fy) && !check[nx][ny]) {
					check[nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
				}
			}
		}
	}
	
	public static void B(int x, int y) {
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
				
				if(nx >= 0 && nx < rc && ny >= 0 && ny < rc && !check[nx][ny]) {
					if(map[fx].charAt(fy) == 'B') {
						if(map[nx].charAt(ny) == map[fx].charAt(fy)) {
							check[nx][ny] = true;
							qx[++rearX] = nx;
							qy[++rearY] = ny;
						}
						continue;
					}
					if(map[nx].charAt(ny) != 'B') {
						check[nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;
					}
				}
			}
		}
	}
} // end of class
