import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < len; i++) {
			ch = str.charAt(i);
			if(ch < 'A' || ch > 'Z') {
				continue;
			}
			
			if(sb.length() == 0 && ch =='U') {
				sb.append(ch);
			}else if(sb.length() == 1 && ch == 'C') {
				sb.append(ch);
			}else if(sb.length() == 2 && ch == 'P') {
				sb.append(ch);
			}else if(sb.length() == 3 && ch == 'C') {
				sb.append(ch);
			}else if(sb.length() == 4) {
				break;
			}
		}
		
		if("UCPC".equals(sb.toString())) {
			System.out.println("I love UCPC");
		}else {
			System.out.println("I hate UCPC");
		}
	}
}
