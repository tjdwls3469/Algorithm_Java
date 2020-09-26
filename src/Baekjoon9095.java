import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	D[n] : 정수 n을 1,2,3의 합으로 나타내는 방법의 수
 * 	D[n] = D[n-1] + D[n-2] + D[n-3]
 * 	(n-1에서 +1) + (n-2에서 +2) + (n-3에서 +3)
 */

public class Baekjoon9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for (int i = 0; i < T; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
		}
		
		System.out.print(sb);
	}
}
