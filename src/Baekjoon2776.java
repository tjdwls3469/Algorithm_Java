import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon2776 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		HashMap<String, Boolean> map = new HashMap<>();
		StringTokenizer st;
		int N, M;
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				map.put(st.nextToken(), true);
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				if(map.get(st.nextToken()) == null) {
					sb.append(0).append('\n');
					continue;
				}
				
				sb.append(1).append('\n');
			}
			map.clear();
		}
		
		System.out.print(sb);
	}
}
