import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18511 {
	private static int N, K;
	private static int[] ary;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String strN = st.nextToken();
		int lenN = strN.length();
		nums = new int[lenN];
		N = Integer.parseInt(strN);
		K = Integer.parseInt(st.nextToken());
		
		ary = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		while(ans == Integer.MIN_VALUE) {
			permutaion(0, lenN);
			lenN--;
		}
		System.out.println(ans);
	}
	
	public static int[] nums;
	public static int ans = Integer.MIN_VALUE;

	private static void permutaion(int cnt, int lenN) {
		if(cnt == lenN) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lenN; i++) {
				sb.append(nums[i]);
			}
			int num = Integer.parseInt(sb.toString());
			if(num <= N && num > ans) {
				ans = num;
			}
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			nums[cnt] = ary[i];
			permutaion(cnt + 1, lenN);
		}
	}
}
