import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[1000001];

		memo[2] = memo[3] = 1;
		for (int i = 4; i <= N; i++) {
			memo[i] = memo[i - 1];

			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i / 3], memo[i]);
			}

			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i / 2], memo[i]);
			}
			
			memo[i]++;
		}
		
		System.out.println(memo[N]);
	}
}
