import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11726_ver2 {
	public static int mod = 10007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[1001];
		memo[1] = 1;
		memo[2] = 2;
		for (int i = 3; i <= 1000; i++) {
			memo[i] = (memo[i-1] % mod + memo[i-2] % mod) % mod;
		}
		System.out.println(memo[n]);
	}
}
