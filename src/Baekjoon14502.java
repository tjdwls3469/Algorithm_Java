import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon14502 {
	private static int row;
	private static int col;
	private static int rc;
	private static char[][] map;
	private static boolean[][] check;
	private static int zeroCnt;
	private static int twoCnt;
	private static int[] twoX = new int[10];
	private static int[] twoY = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		row = line.charAt(0) - '0';
		col = line.charAt(2) - '0';
		rc = row * col;
		map = new char[row][col];
		check = new boolean[row][col];
		
		qx = new int[rc];
		qy = new int[rc];
		
		for (int i = 0; i < row; i++) {
			line = br.readLine();
			for (int j = 0, index = 0; j < col; j++, index += 2) {
				map[i][j] = line.charAt(index);
				if(map[i][j] == '0') {
					zeroCnt++;
				}else if(map[i][j] == '2') {
					twoX[twoCnt] = i;
					twoY[twoCnt] = j;
					twoCnt++;
				}
			}
		}
		
		for (int i = 0; i < rc; i++) {
			if(map[i/col][i%col] != '0') {
				continue;
			}
			
			for (int j = i+1; j < rc; j++) {
				if(map[j/col][j%col] != '0') {
					continue;
				}
				
				for (int k = j+1; k < rc; k++) {
					if(map[k/col][k%col] != '0') {
						continue;
					}
					
					map[i/col][i%col] = '1';
					map[j/col][j%col] = '1';
					map[k/col][k%col] = '1';
					
					bfs();
					if(safyZone > ans) {
						ans = safyZone;
					}
					
					map[i/col][i%col] = '0';
					map[j/col][j%col] = '0';
					map[k/col][k%col] = '0';
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	
	public static int frontX, rearX, frontY, rearY;
	public static int[] qx;
	public static int[] qy;
	
	public static int fx, fy, nx, ny;
	public static int safyZone;
	public static int ans = Integer.MIN_VALUE;

	private static void bfs() {
		for (int i = 0; i < row; i++) {
			Arrays.fill(check[i], false);
		}
		frontX = rearX = frontY = rearY = -1;
		safyZone = zeroCnt - 3;
		
		for (int i = 0; i < twoCnt; i++) {
			check[twoX[i]][twoY[i]] = true;
			qx[++rearX] = twoX[i];
			qy[++rearY] = twoY[i];
		}
		
		while(rearX != frontX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == '0' && !check[nx][ny]) {
					check[nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					safyZone--;
				}
			}
		}
	}
	
	public static void print() {
		System.out.println();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
