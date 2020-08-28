import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3234 {
	public static int N;
	public static int[] weight = new int[9];
	public static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			permutation(0, 0, 0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}

	private static void permutation(int cnt, int rightSum, int leftSum) {
		if(cnt == N) {
			ans++;
			return;
		}
		
		for (int i = cnt; i < N; i++) {
			int temp = weight[cnt];
			weight[cnt] = weight[i];
			weight[i] = temp;

			permutation(cnt + 1, rightSum, leftSum  + weight[cnt]);
			if(rightSum + weight[cnt] <= leftSum) {
				permutation(cnt + 1, rightSum + weight[cnt], leftSum);
			}
			
			temp = weight[cnt];
			weight[cnt] = weight[i];
			weight[i] = temp;
		}
	}
}
