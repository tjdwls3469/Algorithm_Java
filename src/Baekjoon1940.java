import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] ary = new int[N];
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);

		int left = 0;
		int right = N - 1;
		int ans = 0;
		int sum;
		
		while(left < right) {
			sum = ary[left] + ary[right];
			if(sum == M) {
				ans++;
				left++;
				right--;
			}else if(sum < M) {
				left++;
			}else {
				right--;
			}
		}
		
		System.out.println(ans);
	}
}
