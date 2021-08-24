import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		int[] check = new int['z'+1];
		for (int i = 0; i < S.length(); i++) {
			check[S.charAt(i)]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(check[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
