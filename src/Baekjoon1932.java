import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] memo = new int[n][n];
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo[0][0] = map[0][0];
		for(int i = 1; i < n; i++) {
		    memo[i][0] = memo[i-1][0] + map[i][0];
		    memo[i][i] = memo[i-1][i-1] + map[i][i];
		    
		    for(int j = 1; j < n-1; j++) {
		        memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + map[i][j];
		    }
		}
		
		int ans = memo[n-1][0];
		for (int i = 0; i < n; i++) {
			if(memo[n-1][i] > ans) {
				ans = memo[n-1][i];
			}
		}
		
		System.out.println(ans);
	}
}
