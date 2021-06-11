import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ary = new int[N];
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ary);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ary.length; i++) {
			sb.append(ary[i]).append('\n');
		}
		
		System.out.print(sb);
	}
}
