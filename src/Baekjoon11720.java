import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += Integer.parseInt(str.charAt(i) + "");
		}
		
		System.out.println(ans);
	}
}
