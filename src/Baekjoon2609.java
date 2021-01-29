import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer((new BufferedReader(new InputStreamReader(System.in))).readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int mul = a * b;
		int c;

		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}

		sb.append(a).append('\n').append(mul / a);
		System.out.println(sb);
	}
}
