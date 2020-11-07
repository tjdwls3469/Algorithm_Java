import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1600 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		String line;
		for (int i = 0; i < H; i++) {
			line = br.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				map[i][j] = line.charAt(index);
			}
		}
		
		int size = (K+1) * W * H;
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		int[] horseX = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] horseY = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] qx = new int[size];
		int[] qy = new int[size];
		int[] qd = new int[size];
		int[] qk = new int[size];
		int frontX, rearX, frontY, rearY, frontD, rearD, frontK, rearK;
		int fx, fy, fd, fk, nx, ny, nk;
		frontX = rearX = frontY = rearY = frontD = rearD = frontK = rearK = -1;
		
		boolean[][][] check = new boolean[K+1][H][W];
		int endX = H - 1;
		int endY = W - 1;
		int ans = -1;
		
		check[0][0][0] = true;
		qx[++rearX] = 0;
		qy[++rearY] = 0;
		qd[++rearD] = 0;
		qk[++rearK] = 0;
		
		while(frontX != rearX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			fd = qd[++frontD];
			fk = qk[++frontK];
			
			if(fx == endX && fy == endY) {
				ans = fd;
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '0' && !check[fk][nx][ny]) {
					check[fk][nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					qd[++rearD] = fd + 1;
					qk[++rearK] = fk;
				}
			}
			
			if(fk >= K) {
				continue;
			}
			
			for (int i = 0; i < horseX.length; i++) {
				nx = fx + horseX[i];
				ny = fy + horseY[i];
				nk = fk + 1;
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '0' && !check[nk][nx][ny]) {
					check[nk][nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					qd[++rearD] = fd + 1;
					qk[++rearK] = nk;
				}
			}
		} // end of BFS
		System.out.println(ans);
	}
}
