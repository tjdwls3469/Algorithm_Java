import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0번 +10
//전꺼랑 같으면 +5
//다르면 +10

public class Jungol2604 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		int ans = 10;
		for (int i = 1; i < data.length(); i++) {
			if(data.charAt(i) == data.charAt(i-1)) {
				ans+=5;
			}else {
				ans+=10;
			}
		}
		System.out.println(ans);
	}
}
