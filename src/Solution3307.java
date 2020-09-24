

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3307 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[] ary = new int[1000];
		int[] LIS = new int[1000];
		int max;
		int N;
		
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				ary[i] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				
				for (int j = 0; j < i; j++) {
					if(ary[i] > ary[j] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				
				if(LIS[i] > max) {
					max = LIS[i];
				}
			}
			
			sb.append('#').append(tc).append(' ').append(max).append('\n');
		} // end of for (tc)
		System.out.print(sb);
	} // end of main
}
