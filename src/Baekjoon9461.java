import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] memo = new long[101];
//		1, 1, 1, 2, 2, 3, 4, 5, 7, 9
		memo[1] = 1;
		memo[2] = 1;
		memo[3] = 1;
		memo[4] = 2;
		memo[5] = 2;
		memo[6] = 3;
		memo[7] = 4;
		memo[8] = 5;
		memo[9] = 7;
		memo[10] = 9;
		
		for (int i = 11; i <= 100; i++) {
			memo[i] = memo[i-1] + memo[i-5];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(memo[Integer.parseInt(br.readLine())]).append('\n');
		}
		
		System.out.print(sb);
	}
}
