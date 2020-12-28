import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] ary = new int[N];
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 1;
		int[] check = new int[d+1];
		check[c] = 1;
		for (int i = 0; i < k; i++) {
			if(check[ary[i]] != 0) {
				check[ary[i]]++;
				continue;
			}
			
			check[ary[i]]++;
			ans++;
		}
		
		int left = 0;
		int right = k;
		int cnt = ans;
		
		while(left < N) {
			if(right >= N) {
				right = 0;
			}
			
			if(check[ary[right]] == 0) {
				cnt++;
			}
			check[ary[right]]++;
			
			check[ary[left]]--;
			if(check[ary[left]] == 0) {
				cnt--;
			}
			
			if(cnt > ans) {
				ans = cnt;
			}
			
			left++;
			right++;
		}
		
		System.out.println(ans);
	}
}
