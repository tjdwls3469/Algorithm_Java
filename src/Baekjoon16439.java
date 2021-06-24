import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16439 {
	private static int N, M;
	private static int[] nums = new int[3];
	private static int[][] map;
	private static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(ans);
	}

	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				int person = 0;
				
				for (int j = 0; j < 3; j++) {
					if(map[i][nums[j]] > person) {
						person = map[i][nums[j]];
					}
				}
				
				sum += person;
			}
			
			if(sum > ans) {
				ans = sum;
			}
			
			return;
		}
		
		for (int i = start; i < M; i++) {
			nums[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
