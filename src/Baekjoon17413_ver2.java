import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17413_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int len = S.length();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < len; i++) {
			word.setLength(0);
			
			if('<' == S.charAt(i)) {
				while('>' != S.charAt(i)) {
					word.append(S.charAt(i));
					i++;
				}
				word.append(S.charAt(i));
				sb.append(word);
				continue;
			}
			
			while(i < len && '<' != S.charAt(i) && ' ' != S.charAt(i)) {
				word.append(S.charAt(i));
				i++;
			}
			sb.append(word.reverse());
			
			if(i < len && ' ' == S.charAt(i)) {
				sb.append(' ');
			}
			
			if(i < len && '<' == S.charAt(i)) {
				i--;
			}
		}
		
		System.out.println(sb);
	}
}
