import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class 이름 Main으로 제출

public class Jungol2857 {
	public static void main(String[] args) throws IOException {
		StringBuffer ans = new StringBuffer();
		char[][] map = new char[5][15];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[j][i] == '\u0000') {
					continue;
				}
				ans.append(map[j][i]);
			}
		}
		System.out.println(ans);
	}	// end of main
}	// end of class
