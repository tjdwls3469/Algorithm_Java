import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1859 {
	public static int N;
	public static int[] ary = new int[1000000];
	public static StringTokenizer st;
	public static StringBuilder ans = new StringBuilder();
	public static int max;
	public static long profit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				ary[i] = Integer.parseInt(st.nextToken());
			}
			
			profit = 0;
			max = ary[N-1];
			for (int i = N-2; i >= 0; i--) {
				if(ary[i] == max) {
					continue;
				}else if(ary[i] < max) {
					profit += max - ary[i];
				}else {
					max = ary[i];
				}
			}
			
			ans.append('#').append(tc).append(' ').append(profit).append('\n');
		} // end of tc
		System.out.print(ans);
	} // end of main
}
