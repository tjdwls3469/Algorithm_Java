import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6603 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] ary = new int[12];
	public static int[] lotto = new int[6];
	public static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				break;
			}
			
			for (int i = 0; i < k; i++) {
				ary[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append('\n');
		}
		
		System.out.print(sb);
	}

	public static void combination(int cnt, int start) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(lotto[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = start; i < k; i++) {
			lotto[cnt] = ary[i];
			combination(cnt + 1, i + 1);
		}
	}
}
