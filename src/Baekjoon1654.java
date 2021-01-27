import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] ary = new int[K];
		for (int i = 0; i < K; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ary);
		long low = 1;
		long high = ary[K-1];
		long mid;
		long cnt = 0;
		long ans = -1;
		
		while(low <= high) {
			mid = (low + high) / 2;
			cnt = 0;
			
			for (int i = 0; i < K; i++) {
				cnt += ary[i]/mid;
			}
			
			if(cnt >= N) {
				if(mid > ans) {
					ans = mid;
				}
				
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}
