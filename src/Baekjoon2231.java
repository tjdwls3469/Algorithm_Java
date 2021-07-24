import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum, num, ans;
		sum = num = ans = 0;
		for (int i = 1; i <= N; i++) {
			sum = num = i;
			
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
