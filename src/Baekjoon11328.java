import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11328 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] check = new int[123];
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < N; t++) {
			Arrays.fill(check, 0);
			st = new StringTokenizer(br.readLine(), " ");
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			int len1 = str1.length();
			int len2 = str2.length();
			
			if(len1 != len2) {
				sb.append("Impossible").append('\n');
				continue;
			}
			
			for (int i = 0; i < len1; i++) {
				check[str1.charAt(i)]++;
			}
			
			char ch;
			boolean isPossible = true;
			for (int i = 0; i < len2; i++) {
				ch = str2.charAt(i);
				if(check[ch] == 0) {
					isPossible = false;
					break;
				}
				
				check[ch]--;
			}
			
			if(isPossible) {
				sb.append("Possible").append('\n');
			}else {
				sb.append("Impossible").append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
