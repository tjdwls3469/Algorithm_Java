import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9229 {
	public static int n;
	public static int m;
	public static int[] snacks = new int[1000];
	public static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= testCase; tc++) {
			st  = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st  = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			ans = -1;
			combination(0, 0, 0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void combination(int cnt, int start, int sum) {
		if(cnt == 2) {
			if(sum <= m && sum > ans) {
				ans = sum;
			}
			return;
		}
		
		for (int i = start; i < n; i++) {
			combination(cnt + 1, i + 1, sum + snacks[i]);
		}
	}
}
