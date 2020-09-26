import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D[n] : N개를 갖기위해 지불해야하는 금액의 최댓값
 * D[1] = cards[1];
 * D[2] = max(cards[2], D[1]+D[1])	
 * D[3] = max(cards[3], D[1]+D[2])	
 * D[4] = max(cards[4], D[1]+D[3], D[2]+D[2])	
 * D[5] = max(cards[5], D[1]+D[4], D[2]+D[3])	
 * D[6] = max(cards[6], D[1]+D[5], D[2]+D[4], D[3]+D[3])	
 */

public class Baekjoon11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] cards = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		int end;
		for (int i = 1; i <= N; i++) {
			dp[i] = cards[i];
			
			end = i/2;
			for (int j = 1; j <= end; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
