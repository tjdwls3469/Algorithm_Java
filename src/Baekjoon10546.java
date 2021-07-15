import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Baekjoon10546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		String key;
		for (int i = 0; i < N; i++) {
			key = br.readLine();
			if(map.get(key) == null) {
				map.put(key, 1);
				continue;
			}
			
			map.put(key, map.get(key) + 1);
		}
		
		int cnt;
		for (int i = 1; i < N; i++) {
			key = br.readLine();
			cnt = map.get(key) - 1;
			if(cnt == 0) {
				map.remove(key);
				continue;
			}
			
			map.put(key, cnt);
		}
		
		Set<String> set = map.keySet();
		for (String str : set) {
			System.out.println(str);
		}
	}
}
