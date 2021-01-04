import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon7662 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int k, n, cnt, key;
		String str;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		for (int tc = 0; tc < T; tc++) {
			map.clear();
			k = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				str = st.nextToken();
				n = Integer.parseInt(st.nextToken());
				
				if(str.equals("I")) {
					if(map.containsKey(n)) {
						map.put(n, map.get(n) + 1);
					}else {
						map.put(n, 1);
					}
					
					continue;
				}
				
				if(map.isEmpty()) {
					continue;
				}
				
				if(n == -1) {
					key = map.firstKey();
					cnt = map.get(key) - 1;
				}else {
					key = map.lastKey();
					cnt = map.get(key) - 1;
				}
				
				if(cnt == 0) {
					map.remove(key);
				}else {
					map.put(key, cnt);
				}
			} // end of for
			
			if(map.isEmpty()) {
				sb.append("EMPTY").append('\n');
			}else {
				sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
			}
		} // end of tc
		System.out.print(sb);
	}
}
