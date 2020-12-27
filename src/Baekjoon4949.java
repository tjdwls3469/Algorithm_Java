import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		int len;
		char[] stack = new char[100];
		int top = -1;
		boolean check;
		
		while(true) {
			str = br.readLine();
			
			if(".".equals(str)) {
				break;
			}
			
			top = -1;
			check = false;
			len = str.length();
			for (int i = 0; i < len; i++) {
				if(check) {
					break;
				}
				
				switch (str.charAt(i)) {
				case '(':
					stack[++top] = '(';
					break;
				case '[':
					stack[++top] = '[';
					break;
				case ')':
					if(top < 0 || stack[top--] != '(') {
						check = true;
					}
					break;
				case ']':
					if(top < 0 || stack[top--] != '[') {
						check = true;
					}
					break;
				}
			} // end of for
			if(check || top != -1) {
				sb.append("no").append('\n');
				continue;
			}
			
			sb.append("yes").append('\n');
		} // end of while
		
		System.out.print(sb);
	}
}
