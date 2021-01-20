import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		Pair[] memo  = new Pair[41];
		memo[0] = new Pair(1, 0);
		memo[1] = new Pair(0, 1);
		
		for (int i = 2; i <= 40; i++) {
			memo[i] = new Pair(memo[i-1].zeroCnt + memo[i-2].zeroCnt, memo[i-1].oneCnt + memo[i-2].oneCnt);
		}
		
		int num;
		for (int i = 0; i < T; i++) {
			num = Integer.parseInt(br.readLine());
			sb.append(memo[num].zeroCnt).append(' ').append(memo[num].oneCnt).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static class Pair{
		public int zeroCnt;
		public int oneCnt;
		
		public Pair(int zeroCnt, int oneCnt) {
			super();
			this.zeroCnt = zeroCnt;
			this.oneCnt = oneCnt;
		}
	}
}
