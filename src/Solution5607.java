import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5607 {
	public static final int MOD = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N, R;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			sb.append('#').append(tc).append(' ').append(nCr(N, R, MOD)).append('\n');
		}
		System.out.print(sb);
	}
	
	public static long nCr(int n, int r, int p) {
		if(r == 0) {
			return 1L;
		}
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		return (fac[n]*power(fac[r], p-2, p) % p * power(fac[n-r], p-2, p) % p) % p;
	}
	
	public static long power(long x, long y, long p) {
		long res = 1L;
		
		while(y > 0) {
			if(y % 2 == 1) {
				res = (res * x) % p;
			}
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}
}
