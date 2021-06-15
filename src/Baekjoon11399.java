import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ary = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(ary);
		int ans = 0;
		for (int i = 0; i < ary.length; i++) {
			ans += ary[i] * (N-i);
		}
		
		System.out.println(ans);
	}
}
