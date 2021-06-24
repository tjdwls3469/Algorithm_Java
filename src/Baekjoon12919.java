import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12919 {
	public static int lenS;
	private static int ans;
	private static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		String T = br.readLine();
		lenS = S.length();
		
		recursive(new StringBuilder(T), T.length());
		System.out.println(ans);
	}

	private static void recursive(StringBuilder sb, int len) {
		if(len == lenS) {
			if(S.equals(sb.toString())) {
				ans = 1;
			}
			
			return;
		}
		
		if(sb.charAt(len - 1) == 'A') {
			recursive(new StringBuilder(sb).deleteCharAt(len - 1), len - 1);
		}
		if(sb.charAt(0) == 'B') {
			recursive(new StringBuilder(sb).reverse().deleteCharAt(len - 1), len - 1);
		}
	}
}
