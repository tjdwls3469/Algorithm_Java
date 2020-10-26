import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		char[] stack = new char[100000];
		int top = -1;
		int len = S.length();
		char ch;
		
		for (int i = 0; i < len; i++) {
			ch = S.charAt(i);

			switch (ch) {
			case '<':
				// '<'앞에 단어가 있었다면
				// tag<close> 에서 tag를 뒤집어서 gat 상태로 sb에 넣기
				while(top > -1) {
					sb.append(stack[top--]);
				}
				sb.append(ch);
				
				// <open> 같은거는 그대로  sb에 넣기
				while(true) {
					ch = S.charAt(++i);
					if('>' == ch) {
						sb.append(ch);
						break;
					}
					sb.append(ch);
				}
				break;
				
			case ' ':
				// 공백을 만나면
				// one1 two2 three3 를 거꾸로 1eno 2owt 3eerht 이렇게 sb에 넣기
				while(top > -1) {
					sb.append(stack[top--]);
				}
				sb.append(ch);
				break;
				
			default:
				// 공백(' '), 특수 문자('<', '>')가 아니면 stack에 넣기
				stack[++top] = ch;
				break;
			} // end of switch
		} // end of for
		
		// 공백(' '), 특수 문자('<', '>')가 마지막으로 나온 이후로 문자가 있었다면
		// <int><max>2147483647<long long><max>9223372036854775807 이런상황일때
		// 9223372036854775807 이부분을 뒤집어서
		// 7085774586302733229 이렇게 sb에 넣기
		while(top > -1) {
			sb.append(stack[top--]);
		}
		
		System.out.println(sb);
	}
}
