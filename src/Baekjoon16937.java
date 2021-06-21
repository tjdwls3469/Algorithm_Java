import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16937 {
	public static int H, W, N;
	public static int[] R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		R = new int[N];
		C = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			R[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0);
		System.out.println(ans);
	}

	public static int[] nums = new int[2];
	public static int ans = 0;

	private static void combination(int cnt, int start) {
		if (cnt == 2) {
			
			
			int area = H * W;
			boolean isGood = true;

			for (int i = 0; i < cnt; i++) {
				int index = nums[i];
				int r = R[index];
				int c = C[index];

				if ((r <= W && c <= H) || (r <= H && c <= W)) {
					area -= r * c;
					continue;
				}

				isGood = false;
			}

			if (!isGood || area < 0) {
				return;
			}
			
			if(!(R[nums[0]] + C[nums[0]] <= H || R[nums[1]] + C[nums[1]] <= W || R[nums[0]] + C[nums[1]] <= H || R[nums[1]] + C[nums[0]] <= W)) {
				return;
			}

			int val = H * W - area;

			if (val > ans) {
				ans = val;
			}

			return;
		}

		for (int i = start; i < N; i++) {
			nums[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
