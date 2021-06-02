import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] ary = new String[5];
		for (int i = 0; i < 5; i++) {
			ary[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(ary[j].length() < i + 1) {
					continue;
				}
				
				sb.append(ary[j].charAt(i));
			}
		}
		
		System.out.println(sb);
	}
}
