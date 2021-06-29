import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] check = new int[10001];
		for (int i = 0; i < N; i++) {
			check[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < check[i]; j++) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
