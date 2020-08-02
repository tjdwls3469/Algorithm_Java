import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15650 {
	public static int n;
	public static int m;
	public static int[] nums = new int[9];
	public static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		permutation(0, 1);
		System.out.print(ans);
	}
	
	public static void permutation(int cnt, int start) {
		if(cnt == m) {
			for (int i = 0; i < m; i++) {
				ans.append(nums[i]).append(' ');
			}
			ans.append('\n');
		}
		
		for (int i = start; i <= n; i++) {
			nums[cnt] = i;
			permutation(cnt + 1, i + 1);
		}
	}
}
