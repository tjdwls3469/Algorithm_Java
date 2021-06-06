import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), true);
		}
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			if(map.get(br.readLine()) != null) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
