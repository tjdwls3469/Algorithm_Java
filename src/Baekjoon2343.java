import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2343 {
	public static int N;
	public static int M;
	public static int[] ary = new int[100000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int low = 1;
		int high = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			high += ary[i];
		}	// ary 초기화 OK
		
		int mid = 0;
		int ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(check(mid)) {
				high = mid - 1;
				ans = mid;
				continue;
			}
			low = mid + 1;
		}
		
		System.out.println(ans);
	}

	public static boolean check(int BluraySize) {
		int sum = 0;
		int BlurayCnt = 1;
		
		for (int i = 0; i < N; i++) {
			if(ary[i] > BluraySize) {
				return false;
			}
			
			sum += ary[i];
			if(sum > BluraySize) {
				BlurayCnt++;
				sum = ary[i];
			}
		}
		return BlurayCnt <= M;
	}
}
