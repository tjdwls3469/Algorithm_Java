import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[26]; // 'a'의 아스키코드값 : 97, 'z'의 아스키코드값 : 122
		
		int ans = 0;
		String str;
		int len, index;
		char ch;
		boolean isAns;
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(check, false);
			isAns = true;
			
			str = br.readLine();
			len = str.length();
			
			for (int j = 0; j < len; j++) {
				ch = str.charAt(j);
				
				index = ch-'a';
				if(!check[index]) { // 현재 문자(ch)가 처음 등장했으면 
					check[index] = true;
					continue;
				}
				
				// 현재 문자(ch)가 이미 등장했을때
				if(ch != str.charAt(j-1)) { // 바로 앞에 문자와 다르면 답이 될 수 없다
					isAns = false;
					break;
				}
			}
			
			if(isAns) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
