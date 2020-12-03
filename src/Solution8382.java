import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8382 {
	public static int startX, startY, endX, endY;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int ans;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			startX = Integer.parseInt(st.nextToken()) + 100;
			startY = Integer.parseInt(st.nextToken()) + 100;
			endX = Integer.parseInt(st.nextToken()) + 100;
			endY = Integer.parseInt(st.nextToken()) + 100;
			
			ans = bfs(startX, startY);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static int[] qx = new int[404010];
	public static int[] qy = new int[404010];
	public static int[] qd = new int[404010];
	public static char[] qrc = new char[404010];
	public static int frontX, rearX, frontY, rearY, frontD, rearD, frontRC, rearRC;
	public static int fx, fy, nx, ny, fd;
	public static boolean[][][] check = new boolean[2][201][201];
	public static String str;

	public static int bfs(int x, int y) {
		frontX = rearX = frontY = rearY = frontD = rearD = frontRC = rearRC = -1;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 201; j++) {
				for (int k = 0; k < 201; k++) {
					check[i][j][k] = false;
				}
			}
		}
		
		check[0][x][y] = true;
		qx[++rearX] = x;
		qy[++rearY] = y;
		qd[++rearD] = 0;
		qrc[++rearRC] = 'R';
		check[1][x][y] = true;
		qx[++rearX] = x;
		qy[++rearY] = y;
		qd[++rearD] = 0;
		qrc[++rearRC] = 'C';
		
		while(frontX != rearX) {
			int size = rearX - frontX;
			
			for (int i = 0; i < size; i++) {
				fx = qx[++frontX];
				fy = qy[++frontY];
				fd = qd[++frontD];
				
				if(fx == endX && fy == endY) {
					return fd;
				}
				
				if(qrc[++frontRC] == 'R') {
					nx = fx;
					ny = fy + 1;
					if(ny >= 0 && ny <= 200 && !check[1][nx][ny]) {
						check[1][nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = fd + 1;
						qrc[++rearRC] = 'C';
					}
					
					nx = fx;
					ny = fy - 1;
					if(ny >= 0 && ny <= 200 && !check[1][nx][ny]) {
						check[1][nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = fd + 1;
						qrc[++rearRC] = 'C';
					}
				}else {
					nx = fx + 1;
					ny = fy;
					if(nx >= 0 && nx <= 200 && !check[0][nx][ny]) {
						check[0][nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = fd + 1;
						qrc[++rearRC] = 'R';
					}
					
					nx = fx - 1;
					ny = fy;
					if(nx >= 0 && nx <= 200 && !check[0][nx][ny]) {
						check[0][nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = fd + 1;
						qrc[++rearRC] = 'R';
					}
				}
			}
		}
		return 0;
	}
}
