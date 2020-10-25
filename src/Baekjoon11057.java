import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * d[n][k] : 길이가 n이고 마지막수가 k인 오르막 수의 개수
 * 
 * d[1][0] = 0
 * d[1][1] = 1 
 * d[1][2] = 1 
 * d[1][3] = 1 
 * d[1][4] = 1 
 * d[1][5] = 1 
 * d[1][6] = 1 
 * d[1][7] = 1 
 * d[1][8] = 1 
 * d[1][9] = 1 
 * 
 * d[2][k] = d[1][k] ~ d[1][9]
 */

public class Baekjoon11057 {
	private static final int MOD = 10007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] memo = new int[1001][10];
		
		for (int i = 0; i <= 9; i++) {
			memo[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k <= 9; k++) {
					memo[i][j] = (memo[i][j] + memo[i-1][k]) % MOD;
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans = (ans + memo[N][i]) % MOD;
		}
		
		System.out.println(ans);
	}
}
