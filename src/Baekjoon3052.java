import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3052 {
	public static final int CNT = 10;
	public static final int MOD = 42;
	public static boolean[] check = new boolean[MOD];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		for (int i = 0; i < CNT; i++) {
			int num = Integer.parseInt(br.readLine()) % MOD;
			if(!check[num]) {
				check[num] = true;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
