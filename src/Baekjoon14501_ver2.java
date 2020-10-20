import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501_ver2 {
	public static int N;
	public static int[] T;
	public static int[] P;
	public static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		generateSet(0, 0);
		System.out.println(ans);
	}
	
	public static void generateSet(int cnt, int sum) {
		if(cnt >= N) {
			if(cnt == N && sum > ans) {
				ans = sum;
			}
			return;
		}
		
		generateSet(cnt + T[cnt], sum + P[cnt]);
		generateSet(cnt + 1, sum);
	}
}
