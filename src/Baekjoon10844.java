

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * d[n][k] : 길이가 n이고 마지막 수가 k인 계단 수 개수
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
 * d[2][0] = d[1][1]
 * d[2][1] = d[1][0] + d[1][2]
 * d[2][2] = d[1][1] + d[1][3]
 * d[2][3] = d[1][2] + d[1][4]
 * d[2][4] = d[1][3] + d[1][5]
 * d[2][5] = d[1][4] + d[1][6]
 * d[2][6] = d[1][5] + d[1][7]
 * d[2][7] = d[1][6] + d[1][8]
 * d[2][8] = d[1][7] + d[1][9]
 * d[2][9] = d[1][8]
 */

public class Baekjoon10844 {
	private static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] memo = new int[101][10];
		
		for (int i = 1; i <= 9; i++) {
			memo[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			memo[i][0] = memo[i-1][1];
			memo[i][9] = memo[i-1][8];
			
			for (int j = 1; j <= 8; j++) {
				memo[i][j] = (memo[i-1][j-1]%MOD + memo[i-1][j+1]%MOD) % MOD;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = (ans + memo[N][i]) % MOD;
		}
		
		System.out.println(ans);
	}
}
