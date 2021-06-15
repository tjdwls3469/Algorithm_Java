import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9934 {
	private static int[] ary;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		cnt = (int) Math.pow(2, K);
		ary = new int[cnt];
		for (int i = 1; i < cnt; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		inOrder(1);
	}

	public static void inOrder(int cur) {
		if(cur > cnt - 1) {
			return;
		}
		
		inOrder(cur*2);
		System.out.print(ary[cur] + " ");
		inOrder(cur*2+1);
	}
}
