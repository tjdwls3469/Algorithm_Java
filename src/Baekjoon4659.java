import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();
			if ("end".equals(str)) {
				break;
			}

			sb.append('<').append(str).append('>').append(' ');

			// 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
			boolean check1 = false;
			int len = str.length();
			for (int i = 0; i < len; i++) {
				if (isAEIOU(str.charAt(i))) {
					check1 = true;
					break;
				}
			}

			if (!check1) {
				sb.append("is not acceptable.").append('\n');
				continue;
			}

			// 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
			boolean check2 = false;
			for (int i = 2; i < len; i++) {
				if (isAEIOU(str.charAt(i)) && isAEIOU(str.charAt(i - 1)) && isAEIOU(str.charAt(i - 2))) {
					check2 = true;
					break;
				}
				
				if (!isAEIOU(str.charAt(i)) && !isAEIOU(str.charAt(i - 1)) && !isAEIOU(str.charAt(i - 2))) {
					check2 = true;
					break;
				}
			}
			
			if(check2) {
				sb.append("is not acceptable.").append('\n');
				continue;
			}
			
			// 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
			boolean check3 = false;
			for (int i = 1; i < len; i++) {
				char ch = str.charAt(i);
				if (ch == str.charAt(i-1) && ch != 'e' && ch != 'o') {
					check3 = true;
					break;
				}
			}
			
			if(check3) {
				sb.append("is not acceptable.").append('\n');
				continue;
			}
			
			// 좋은 패스워드인 경우
			sb.append("is acceptable.").append('\n');
		} // end of while
		System.out.print(sb);
	}

	public static boolean isAEIOU(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			return true;
		}

		return false;
	}
}
