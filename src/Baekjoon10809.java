import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int len = S.length();
		int[] check = new int['z' + 1];
		Arrays.fill(check, -1);

		for (int i = 0; i < len; i++) {
			char c = S.charAt(i);
			if(check[c] != -1) {
				continue;
			}
			
			check[c] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(check[i]).append(' ');
		}
		System.out.println(sb);
	}
}
