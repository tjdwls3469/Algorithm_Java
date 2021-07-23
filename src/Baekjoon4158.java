import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon4158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) {
				break;
			}
			
			map.clear();
			for (int i = 0; i < N; i++) {
				map.put(br.readLine(), true);
			}
			
			ans = 0;
			for (int i = 0; i < M; i++) {
				if(map.get(br.readLine()) == null) {
					continue;
				}
				
				ans++;
			}
			
			sb.append(ans).append('\n');
		}
		System.out.print(sb);
	}
}
