import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon21918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] ary = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			switch (a) {
			case 1:
				ary[b] = c;
				break;
				
			case 2:
				for (int j = b; j <= c; j++) {
					ary[j] = ary[j] == 1 ? 0 : 1;
				}
				break;
				
			case 3:
				for (int j = b; j <= c; j++) {
					ary[j] = 0;
				}
				break;

			default:
				for (int j = b; j <= c; j++) {
					ary[j] = 1;
				}
				break;
			}
		} // end of for
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(ary[i]).append(' ');
		}
		System.out.println(sb);
	}
}
