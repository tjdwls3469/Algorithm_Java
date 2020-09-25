import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	그림 그려보면서 규칙 발견함
 * 	D[n] : 2xn을 채우는 방법의 수
 *	D[n] = D[n-1] + D[n-2]
 *	n = n-1에 2x1 추가 + n-2에서 1x2 추가
 */

public class Baekjoon11726 {
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
