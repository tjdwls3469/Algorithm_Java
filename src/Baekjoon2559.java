import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ary = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = K-1;
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum += ary[i];
		}
		int ans = sum;
		
		while(true) {
			right++;
			
			if(right >= N) {
				break;
			}
			
			sum += ary[right];
			sum -= ary[left];
			left++;
			
			if(sum > ans) {
				ans = sum;
			}
		}
		
		System.out.println(ans);
	}
}
