import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2798_ver2 {
	public static int N, M;
	public static int[] isSelected = new int[3];
	public static int[] ary;
	public static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0);
		System.out.println(ans);
	}

	public static void combination(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += isSelected[i];
			}
			
			if(sum <= M) {
				if(sum > ans) {
					ans = sum;
				}
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			isSelected[cnt] = ary[i];
			combination(cnt + 1, i + 1);
		}
	}
}
