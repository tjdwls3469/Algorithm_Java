import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5597 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] ary = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			ary[Integer.parseInt(br.readLine())] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < ary.length; i++) {
			if(!ary[i]) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
