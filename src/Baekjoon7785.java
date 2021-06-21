import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon7785 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String action = st.nextToken();

			if ("leave".equals(action)) {
				map.remove(name);
				continue;
			}

			map.put(name, true);
		}
		
		Set<String> set = map.keySet();
		StringBuilder sb = new StringBuilder();
		for (String str : set) {
			sb.append(str).append('\n');
		}
		System.out.print(sb);
	}
}
