import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon20291 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> map = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String str = st.nextToken();
			
			if(!map.containsKey(str)) {
				map.put(str, 1);
				continue;
			}
			
			map.put(str, map.get(str) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> ent : map.entrySet()) {
			sb.append(ent.getKey()).append(' ').append(ent.getValue()).append('\n');
		}
		System.out.print(sb);
	}
}
