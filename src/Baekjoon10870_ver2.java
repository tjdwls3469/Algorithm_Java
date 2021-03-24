import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10870_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 1];

		if (n == 0) {
			System.out.println(0);
			System.exit(0);
		}

		if (n == 1 || n == 2) {
			System.out.println(1);
			System.exit(0);
		}

		memo[1] = memo[2] = 1;
		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		System.out.println(memo[n]);
	}
}
