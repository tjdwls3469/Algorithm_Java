import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1003_ver3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] memo0 = new int[41];
		int[] memo1 = new int[41];
		
		memo0[0] = memo1[1] = memo0[2] = memo1[2] = 1;
		for (int i = 3; i <= 40; i++) {
			memo0[i] = memo0[i-1] + memo0[i-2];
			memo1[i] = memo1[i-1] + memo1[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = 0; i < T; i++) {
			index = Integer.parseInt(br.readLine());
			sb.append(memo0[index]).append(' ').append(memo1[index]).append('\n');
		}
		
		System.out.print(sb);
	}
}
