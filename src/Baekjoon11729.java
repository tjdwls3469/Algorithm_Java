import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11729 {
	public static int cnt = 0;
	public static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hanoi(Integer.parseInt(br.readLine()), 1, 2, 3);
		System.out.println(cnt);
		System.out.println(ans);
	}
	
	public static void hanoi(int num, int start, int mid, int end) {
		if(num == 0) {
			return;
		}
		hanoi(num-1, start, end, mid);
		ans.append(start + " " + end + '\n');
		cnt++;
		hanoi(num-1, mid, start, end);
	}
}
