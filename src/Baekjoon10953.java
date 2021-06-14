import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10953 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int A, B;
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append(A + B).append('\n');
		}
		
		System.out.print(sb);
	}
}
