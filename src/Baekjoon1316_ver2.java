import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1316_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		boolean[] check = new boolean['z' + 1 ];
		
		for (int t = 0; t < N; t++) {
			String str = br.readLine();
			int len = str.length();
			Arrays.fill(check, false);
			
			check[str.charAt(0)] = true;
			boolean isGood = true;
			for (int i = 1; i < len; i++) {
				char ch = str.charAt(i);
				if(ch == str.charAt(i-1)) {
					continue;
				}
				
				if(check[ch]) {
					isGood = false;
					break;
				}
				
				check[ch] = true;
			}
			
			if(isGood) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
