import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		if(M >= 45) {
			sb.append(H).append(' ').append(M - 45);
			System.out.println(sb);
			System.exit(0);
		}
		
		if(H == 0) {
			sb.append(23);
		}else {
			sb.append(H - 1);
		}
		sb.append(' ').append((M+60) - 45);
		System.out.println(sb);
	}
}
