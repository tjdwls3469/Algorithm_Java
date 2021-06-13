import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<String, Integer> map = new HashMap<>();
		String key;
		for (int i = 0; i < N; i++) {
			key = st.nextToken();
			
			if(map.get(key) == null) {
				map.put(key, 1);
				continue;
			}
			
			map.put(key, map.get(key) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			key = st.nextToken();
			
			if(map.get(key) == null) {
				sb.append(0).append(' ');
				continue;
			}
			
			sb.append(map.get(key)).append(' ');
		}
		
		System.out.println(sb);
	}
}
