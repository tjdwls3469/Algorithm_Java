import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		int len = S.length();
		String[] ary = new String[len];
		for (int i = 0; i < len; i++) {
			ary[i] = S.substring(i);
		}
		
		Arrays.sort(ary);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			sb.append(ary[i]).append('\n');
		}
		
		System.out.print(sb);
	}
}
