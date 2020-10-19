import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon15688 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] ary = new int[Integer.parseInt(br.readLine())];
		
		for (int i = 0; i < ary.length; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ary);
		for (int i = 0; i < ary.length; i++) {
			sb.append(ary[i]).append('\n');
		}
		
		System.out.print(sb);
	}
}
