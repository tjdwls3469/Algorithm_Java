import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3184 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][];
		String line;
		for (int i = 0; i < R; i++) {
			line = br.readLine();
			map[i] = line.toCharArray();
		}
		
		int v, o;
		int sheepCnt = 0;
		int wolfCnt = 0;
		
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		int size = R* C;
		int[] qx = new int[size];
		int[] qy = new int[size];
		int frontX, rearX, frontY, rearY;
		int fx, fy, nx, ny;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#') {
					v = o = 0;
					frontX = rearX = frontY = rearY = -1;
					
					// BFS
					switch (map[i][j]) {
					case 'o':
						o++;
						break;
					case 'v':
						v++;
						break;
					}
					map[i][j] = '#';
					qx[++rearX] = i;
					qy[++rearY] = j;
					
					while(frontX != rearX) {
						fx = qx[++frontX];
						fy = qy[++frontY];
						
						for (int k = 0; k < dx.length; k++) {
							nx = fx + dx[k];
							ny = fy + dy[k];
							
							if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '#') {
								switch (map[nx][ny]) {
								case 'o':
									o++;
									break;
								case 'v':
									v++;
									break;
								}
								map[nx][ny] = '#';
								qx[++rearX] = nx;
								qy[++rearY] = ny;
							}
						}
					} // end of BFS
					if(o > v) {
						sheepCnt += o;
					}else {
						wolfCnt += v;
					}
				}
			}
		} // end of 이중 for문
		System.out.println(sheepCnt + " " + wolfCnt);
	}
}
