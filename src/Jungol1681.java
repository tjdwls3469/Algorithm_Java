import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1681 {
	public static int N;
	public static int[][] map;
	public static boolean[] check;
	public static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // OK
		
		check[0] = true;
		solve(0, 0, 0);
		System.out.println(ans);
	}

	private static void solve(int cnt, int index, int sum) {
		if(cnt == N - 1) {
			if(map[index][0] != 0 && sum + map[index][0] < ans) {
				ans = sum + map[index][0];
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!check[i] && map[index][i] != 0 && sum + map[index][i] < ans) {
				check[i] = true;
				solve(cnt + 1, i, sum + map[index][i]);
				check[i] = false;
			}
		}
	}
}
