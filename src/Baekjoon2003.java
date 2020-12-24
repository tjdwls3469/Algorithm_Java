import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ary = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = ary[0];
		int ans = 0;
		
		while(left <= right && right < N) {
			if(sum < M) {
				right++;
				sum += ary[right];
			}else if(sum == M) {
				ans++;
				right++;
				sum += ary[right];
			}else {
				sum -= ary[left];
				left++;
				if(left > right && left < N) {
					right = left;
					sum = ary[left];
				}
			}
		}
		
		System.out.println(ans);
	}
}
