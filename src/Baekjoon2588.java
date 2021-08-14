import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int[] ans = new int[4];
		
		int index = 0;
		while(num2 > 0) {
			int num = num2 % 10;
			ans[index++] = num1 * num;
			num2 /= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans[0]).append('\n')
		  .append(ans[1]).append('\n')
		  .append(ans[2]).append('\n')
		  .append(ans[0] + (ans[1]*10) + (ans[2]*100));
		System.out.println(sb);
	}
}
