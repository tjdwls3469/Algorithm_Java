import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2750_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[2001];
		for (int i = 0; i < N; i++) {
			check[Integer.parseInt(br.readLine()) + 1000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 2000; i++) {
			if(!check[i]) {
				continue;
			}
			
			sb.append(i - 1000).append('\n');
		}
		System.out.print(sb);
	}
}
