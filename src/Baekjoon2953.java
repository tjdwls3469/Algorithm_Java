import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2953 {
	public static final int CNT = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		int score = -1;
		for (int i = 0; i < CNT; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int sum = 0;
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			if(score == -1 || sum > score) {
				score = sum;
				num = i+1;
			}
		}
		System.out.println(num + " " + score);
	}
}
