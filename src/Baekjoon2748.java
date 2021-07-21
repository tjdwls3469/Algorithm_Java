import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2748 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] memo = new long[91];
		memo[1] = 1;
		for (int i = 2; i <= 90; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		System.out.println(memo[n]);
	}
}