import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1629 {
	public static int mod;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		mod = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(A, X) % mod);
	}

	private static long solve(int A, int X) {
		if(X == 1) {
			return A % mod;
		}
		
		long result = solve(A, X / 2);
		result *= result;
		result %= mod;
		if(X % 2 != 0) {
			result *= A % mod;
		}
		return result % mod;
	}
}