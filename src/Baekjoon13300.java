import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] check = new int[2][7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			check[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		
		int ans = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				ans += check[i][j] / K;
				
				if (check[i][j] % K == 0) {
					continue;
				}
				
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
