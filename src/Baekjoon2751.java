import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751 {
	public static boolean[] check = new boolean[1000001 * 2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			check[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < check.length; i++) {
			if(!check[i]) {
				continue;
			}
			
			sb.append(i - 1000000).append('\n');
		}
		
		System.out.print(sb);
	}
}
