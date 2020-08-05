import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16234 {
	public static int N;
	public static int L;
	public static int R;
	public static int[][] map = new int[50][50];
	public static boolean[][] check = new boolean[50][50];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// map 초기화 OK

		boolean goBFS = false;
		int ans = 0;
		int cnt = 0;
		while(true) {
			
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = false;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(check[i][j]) {
						continue;
					}
					goBFS = false;
					for (int k = 0; k < dx.length; k++) {
						nx = i + dx[k];
						ny = j + dy[k];
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny]) {
							diff = map[i][j] - map[nx][ny];
							if(diff < 0) {
								diff = -diff;
							}
							if(diff >= L && diff <= R) {
								goBFS = true;
								break;
							}
						}
					}
					if(goBFS) {
						cnt++;
						bfs(i,j);
						
						// 연합지역 적용
						int unionVal = unionSum / unionCnt;
						for (int x = 0; x < unionCnt; x++) {
							map[unionX[topX--]][unionY[topY--]] = unionVal;
						}
						continue;
					}
					check[i][j] = true;
				}	// BFS OK
			}
			
			if(cnt == 0) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}	// end of main
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int[] qx = new int[2500];
	public static int[] qy = new int[2500];
	public static int frontX = -1;
	public static int rearX = -1;
	public static int frontY = -1;
	public static int rearY = -1;
	public static int fx = 0;
	public static int fy = 0;
	public static int nx = 0;
	public static int ny = 0;
	public static int diff = 0;
	
	public static int unionSum = 0;
	public static int unionCnt = 0;
	public static int[] unionX = new int[2500];
	public static int[] unionY = new int[2500];
	public static int topX = -1;
	public static int topY = -1;

	public static void bfs(int x, int y) {
		frontX = -1;
		rearX = -1;
		frontY = -1;
		rearY = -1;
		
		topX = -1;
		topY = -1;
		unionSum = 0;
		unionCnt = 0;
		
		check[x][y] = true;
		qx[++rearX] = x;
		qy[++rearY] = y;
		
		while(rearX != frontX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			
			unionX[++topX] = fx;
			unionY[++topY] = fy;
			unionSum += map[fx][fy];
			unionCnt++;
						
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny]) {
					diff = map[fx][fy] - map[nx][ny];
					if(diff < 0) {
						diff = -diff;
					}
					if(diff >= L && diff <= R) {
						check[nx][ny] = true;
						qx[++rearX] = nx;
						qy[++rearY] = ny;						
					}
				}
			}
		}
	}
}
