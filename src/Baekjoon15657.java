import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15657 {
	public static int n;
	public static int m;
	public static int[] input;
	public static int[] nums = new int[1000000];
	public static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		permutation(0, 0);
		System.out.print(ans);
	}
	
	public static void permutation(int cnt, int start) {
		if(cnt == m) {
			for (int i = 0; i < m; i++) {
				ans.append(nums[i]).append(' ');
			}
			ans.append('\n');
			return;
		}
		
		for (int i = start; i < n; i++) {
			nums[cnt] = input[i];
			permutation(cnt + 1, i);
		}
	}
}
