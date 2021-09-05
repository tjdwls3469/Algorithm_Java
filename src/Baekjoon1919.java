import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[] check = new int['z' + 1];
		int cnt = str1.length();
		for (int i = 0; i < cnt; i++) {
			check[str1.charAt(i)]++;
		}
		
		int ans = 0;
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			if(check[ch] == 0) {
				ans++;
				continue;
			}
			
			check[ch]--;
			cnt--;
		}
		
		System.out.println(ans + cnt);
	}
}
