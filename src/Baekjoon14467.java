import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14467 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] check = new int[N+1];
		Arrays.fill(check, -1);
		
		int num, loc;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			num = Integer.parseInt(st.nextToken());
			loc = Integer.parseInt(st.nextToken());
			
			if(check[num] == -1) {
				check[num] = loc;
				continue;
			}
			
			if(check[num] == loc) {
				continue;
			}
			
			check[num] = loc;
			ans++;
		}
		System.out.println(ans);
	}
}
