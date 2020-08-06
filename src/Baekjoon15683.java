import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15683 {
	public static int row;
	public static int col;
	public static int[][] map = new int[8][8];
	public static int[] cctv = new int[8];
	public static int cctvCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0 || map[i][j] == 6) {
					continue;
				}
				cctv[cctvCnt] = map[i][j];
				cx[cctvCnt] = i;
				cy[cctvCnt] = j;
				cctvCnt++;
			}
		}	// map 초기화 OK		
		solve(0);
		System.out.println(ans);
	}
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int[] dir = new int[8];
	public static int[][] temp = new int[8][8];
	public static int[] cx = new int[8];
	public static int[] cy = new int[8];
	public static int x;
	public static int y;
	public static int ans = Integer.MAX_VALUE;
	public static int cnt = 0;
	
	public static void move(int k, int d) {
		x = cx[k];
		y = cy[k];
		while(x >= 0 && x < row && y >= 0 && y < col) {
			if(map[x][y] == 6) {
				break;
			}
			temp[x][y] = 1;
			x += dx[d];
			y += dy[d];
		}
	}
	
	public static void solve(int cnt) {
		if(cnt == cctvCnt) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			for (int i = 0; i < cctvCnt; i++) {
				switch (cctv[i]) {
				case 1:
					move(i, dir[i]);
					break;
				case 2:
					move(i, dir[i]);
					move(i, dir[i] + 2);
					break;
				case 3:
					move(i, dir[i]);
					move(i, (dir[i]+1)%4);
					break;
				case 4:
					move(i, dir[i]);
					move(i, (dir[i]+1)%4);
					move(i, (dir[i]+2)%4);
					break;
				default:
					move(i, 0);
					move(i, 1);
					move(i, 2);
					move(i, 3);
					break;
				}
			}
			
			cnt = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(temp[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			if(cnt < ans) {
				ans = cnt;
			}
			
			return;
		}	// end of if
		
		switch (cctv[cnt]) {
		case 2:
			for (int i = 0; i < 2; i++) {
				dir[cnt] = i;
				solve(cnt + 1);
			}
			break;
		case 5:
			dir[cnt] = 0;
			solve(cnt + 1);
			break;
		default:	// 1,3,4
			for (int i = 0; i < 4; i++) {
				dir[cnt] = i;
				solve(cnt + 1);
			}
			break;
		}
	}
}
