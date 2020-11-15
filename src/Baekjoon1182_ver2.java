import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1182_ver2 {
	public static int N;
	public static int S;
	public static int[] ary;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		ary = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		generateSet(0, 0);
		if(S == 0) {
			ans--;
		}
		System.out.println(ans);
	}
	
	public static void generateSet(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S) {
				ans++;
			}
			return;
		}

		generateSet(cnt + 1, sum + ary[cnt]);
		generateSet(cnt + 1, sum);
	}
}
