import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15721 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int Pupa = Integer.parseInt(br.readLine());
		
		int bun = 0;
		int daegi = 0;
		int ans = 0;
		int cnt = 2;
		
ex:		while(true) {
			bun++;
			if(Pupa == 0 && bun == T) {
				break;
			}
			ans++;
			ans %= A;
			
			daegi++;
			if(Pupa == 1 && daegi == T) {
				break;
			}
			ans++;
			ans %= A;
			
			bun++;
			if(Pupa == 0 && bun == T) {
				break;
			}
			ans++;
			ans %= A;
			
			daegi++;
			if(Pupa == 1 && daegi == T) {
				break;
			}
			ans++;
			ans %= A;
			
			for (int i = 0; i < cnt; i++) {
				bun++;
				if(Pupa == 0 && bun == T) {
					break ex;
				}
				ans++;
				ans %= A;
			}
			
			for (int i = 0; i < cnt; i++) {
				daegi++;
				if(Pupa == 1 && daegi == T) {
					break ex;
				}
				ans++;
				ans %= A;
			}
			
			cnt++;
		}
		
		System.out.println(ans);
	}
}
