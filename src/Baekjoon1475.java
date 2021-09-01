import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1475 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		int[] check = new int[10];
		int num;
		while(N > 0) {
			num = N % 10;
			
			if(num == 6) {
				check[9]++;
			}else {
				check[num]++;
			}
			
			N /= 10;
		}
		
		int ans = 0;
		check[9] = (check[9]/2) + (check[9]%2);
		for (int i = 0; i < check.length; i++) {
			if(check[i] > ans) {
				ans = check[i];
			}
		}
		
		System.out.println(ans);
	}
}
