import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str;
		int len;
		char ch;
		
		char[] stack = new char[1000000];
		char[] temp = new char[1000000];
		int top, tempTop;
		
		for (int tc = 0; tc < T; tc++) {
			top = tempTop = -1;

			str = br.readLine();
			len = str.length();
			
			for (int i = 0; i < len; i++) {
				ch = str.charAt(i);
				
				switch (ch) {
				// '<' 일때는 왼쪽으로 1만큼 이동
				case '<':
					if(top != -1) {
						temp[++tempTop] = stack[top--];
					}
					break;
					
				// '>' 일때는 오른쪽으로 1만큼 이동
				case '>':
					if(tempTop != -1) {
						stack[++top] = temp[tempTop--];
					}
					break;
					
				// '-' 일때는 앞에 문자 삭제
				case '-':
					if(top != -1) {
						top--;
					}
					break;
					
				// '<' '>' '-' 셋 다 아닐때는 stack에 넣는다
				default:
					stack[++top] = ch;
					break;
				} // end of swich
			} // end of for
			
			for (int i = 0; i <= top; i++) {
				sb.append(stack[i]);
			}
			while(tempTop != -1) {
				sb.append(temp[tempTop--]);
			}
			sb.append('\n');
		} // end of TC
		System.out.print(sb);
	}
}
