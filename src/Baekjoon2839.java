import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[5001];
		memo[0] = memo[1] = memo[2] = memo[4] = -1;
		memo[3] = memo[5] = 1;
		
		int a, b;
		for (int i = 6; i <= N; i++) {
			a = memo[i-3];
			b = memo[i-5];
			
			if(a == -1 && b == -1) {
				memo[i] = -1;
				continue;
			}
			
			if(a == -1 && b != -1) {
				memo[i] = b + 1;
				continue;
			}
			
			if(a != -1 && b == -1) {
				memo[i] = a + 1;
				continue;
			}
			
			memo[i] = Math.min(a, b) + 1;
		}
		
		System.out.println(memo[N]);
	}
}
