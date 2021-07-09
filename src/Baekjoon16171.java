import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16171 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String K = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		int len = S.length();
		for (int i = 0; i < len; i++) {
			char ch = S.charAt(i);
			if(ch >= '0' && ch <= '9') {
				continue;
			}
			
			sb.append(ch);
		}
		
		if(sb.toString().contains(K)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
