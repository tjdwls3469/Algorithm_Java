import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1946 {
	public static int N;
	public static char C;
	public static int K;
	public static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			sb.append('#').append(tc).append('\n');
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				C = st.nextToken().charAt(0);
				K = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < K; j++) {
					sb.append(C);
					if(++cnt == 10) {
						cnt = 0;
						sb.append('\n');
					}
				}
			}
			sb.append('\n');
		} // end of tc
		System.out.print(sb);
	} // end of main
}
