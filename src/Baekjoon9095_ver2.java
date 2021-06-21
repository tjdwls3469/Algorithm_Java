import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] memo = new int[11];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;

		for (int i = 4; i <= 10; i++) {
			memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(memo[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.print(sb);
	}
}
