import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501_ver3 {
	private static int N;
	private static int[] T, P;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		generateSet(1, 0);
		System.out.println(ans);
	}
	
	public static int ans = Integer.MIN_VALUE;

	private static void generateSet(int cnt, int sum) {
		if(cnt == N + 1 && sum > ans) {
			ans = sum;
			return;
		}
		
		if(cnt > N) {
			return;
		}
		
		if(sum > ans) {
			ans = sum;
		}

		generateSet(cnt + T[cnt], sum + P[cnt]);
		generateSet(cnt + 1, sum);
	}
}
