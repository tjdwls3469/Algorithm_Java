import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14620 {
	public static int N, NN, ans = Integer.MAX_VALUE;
	public static int[] nums = new int[3];
	public static boolean[][] check;
	public static int[] dx = new int[] {0, -1, 0, 1};
	public static int[] dy = new int[] {-1, 0, 1, 0};
	public static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		NN = N * N;
		
		check = new boolean[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(ans);
	}

	public static void combination(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = false;
				}
			}
			
			for (int t = 0; t < 3; t++) {
				int x = nums[t] / N;
				int y = nums[t] % N;
				
				if(check[x][y]) {
					return;
				}
				
				check[x][y] = true;
				sum += map[x][y];
				
				for (int i = 0; i < dx.length; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny]) {
						return;
					}
					
					check[nx][ny] = true;
					sum += map[nx][ny];
				}
			} // end of for
			
			if(sum < ans) {
				ans = sum;
			}
			return;
		}
		
		for (int i = start; i < NN; i++) {
			nums[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
