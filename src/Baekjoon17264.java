import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon17264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken());
		}

		String ans = "";
		int point = 0;
		for (int i = 0; i < N; i++) {
			String key = br.readLine();
			String value = map.get(key);

			if (value == null || "L".equals(value)) {
				point -= L;
				if (point < 0) {
					point = 0;
				}

				continue;
			}

			point += W;
			if (point >= G) {
				ans = "I AM NOT IRONMAN!!";
				break;
			}
		}

		if ("".equals(ans)) {
			ans = "I AM IRONMAN!!";
		}
		System.out.println(ans);
	}
}
