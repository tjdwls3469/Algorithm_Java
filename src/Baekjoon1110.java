import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1110 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = N;

		if (N == 0) {
			System.out.println(1);
			System.exit(0);
		}

		int num1, num2, ans = 0;;
		while (true) {
			ans++;
			
			num1 = num / 10;
			num2 = num % 10;
			num = (num2*10) + (num1+num2)%10;
			
			if(num == N) {
				break;
			}
		}
		
		System.out.println(ans);
	}
}
