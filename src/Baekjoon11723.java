import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		int[] S = new int[21];
		String cmd;
		int num = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = st.nextToken();
			if(!"all".equals(cmd) && !"empty".equals(cmd)) {
				num = Integer.parseInt(st.nextToken());
			}
			
			switch (cmd) {
			case "add":
				if(S[num] == 0) {
					S[num]++;
				}
				
				break;
				
			case "remove":
				if(S[num] != 0) {
					S[num]--;
				}
				
				break;
				
			case "check":
				if(S[num] == 0) {
					sb.append(0).append('\n');
				}else {
					sb.append(1).append('\n');
				}
				
				break;
				
			case "toggle":
				if(S[num] == 0) {
					S[num] = 1;
				}else {
					S[num] = 0;
				}
				
				break;
				
			case "all":
				for (int j = 1; j <= 20; j++) {
					S[j] = 1;
				}
				
				break;

			default:
				for (int j = 1; j <= 20; j++) {
					S[j] = 0;
				}
				
				break;
			}
		} // end of for
		System.out.print(sb);
	}
}
