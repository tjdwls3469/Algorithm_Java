import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int num = A * B * C;
		int[] check = new int[10];
		while(num > 0) {
			check[num % 10]++;
			num /= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < check.length; i++) {
			sb.append(check[i]).append('\n');
		}
		System.out.print(sb);
	}
}
