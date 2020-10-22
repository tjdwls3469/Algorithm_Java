

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String word = br.readLine();
		
		str = str.replaceAll(word, "0");
		
		int len = str.length();
		int ans = 0;
		
		for (int i = 0; i < len; i++) {
			if('0' == str.charAt(i)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
