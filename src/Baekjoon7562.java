import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon7562 {
	public static boolean[][] map = new boolean[300][300];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		int rc = 0;
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		StringTokenizer st;
		int[] qx = new int[90000];
		int[] qy = new int[90000];
		int[] qd = new int[90000];
		int frontX = -1;
		int rearX = -1;
		int frontY = -1;
		int rearY = -1;
		int frontD = -1;
		int rearD = -1;
		int fx = 0;
		int fy = 0;
		int fd = 0;
		int nx = 0;
		int ny = 0;
		int nd = 0;
		int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
		StringBuilder sb = new StringBuilder();
		
		while(tc-- > 0) {
			rc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			frontX = rearX = frontY = rearY = frontD = rearD= -1;
			map[startX][startY] = true;
			qx[++rearX] = startX;
			qy[++rearY] = startY;
			qd[++rearD] = 0;
			
			while(rearX != frontX) {
				fx = qx[++frontX];
				fy = qy[++frontY];
				fd = qd[++frontD];
				if(fx == endX && fy == endY) {
					sb.append(fd).append('\n');
					break;
				}
				
				for (int i = 0; i < dx.length; i++) {
					nx = fx + dx[i];
					ny = fy + dy[i];
					nd = fd + 1;
					
					if(nx >= 0 && nx < rc && ny >= 0 && ny < rc && !map[nx][ny]) {
						map[nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = nd;
					}
				}
			}	// BFS 종료
			
			for (int i = 0; i < rc; i++) {
				Arrays.fill(map[i], 0, rc, false);
			}	// map 초기화 OK
		}	// end of while
		System.out.print(sb);
	}	// end of main	
}
