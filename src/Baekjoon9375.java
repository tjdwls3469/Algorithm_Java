import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon9375 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			Map<String, Integer> map = new HashMap<>();
			ArrayList<String> check = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String key = st.nextToken();
				key = st.nextToken();

				if (map.get(key) != null) {
					map.put(key, map.get(key) + 1);
					continue;
				}

				check.add(key);
				map.put(key, 1);
			}

			int ans = 1;
			for (int j = 0; j < check.size(); j++) {
				ans *= (map.get(check.get(j)) + 1);
			}
			
			sb.append(ans - 1).append('\n');
		}
		
		System.out.println(sb);
	}
}
