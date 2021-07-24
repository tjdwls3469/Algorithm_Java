import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Baekjoon2798_ver3 {
	private static int N, M, ans;
	private static int[] ary, nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ary = new int[N];
		nums = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0);
		System.out.println(ans);
	}

	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			int sum = nums[0] + nums[1] + nums[2];
			if(sum > M) {
				return;
			}
			
			if(sum > ans) {
				ans = sum;
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = ary[i];
			combination(cnt+1, i+1);
		}
	}
}
