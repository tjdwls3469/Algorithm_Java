import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15654 {
	public static int n;
	public static int m;
	public static int[] input;
	public static int[] nums = new int[1000000];
	public static boolean[] isSelected = new boolean[8];
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
		permutation(0);
		System.out.print(ans);
	}
	
	public static void permutation(int cnt) {
		if(cnt == m) {
			for (int i = 0; i < m; i++) {
				ans.append(nums[i]).append(' ');
			}
			ans.append('\n');
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			nums[cnt] = input[i];
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
