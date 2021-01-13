import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), true);
		}
		
		String str;
		int cnt = 0;
		ArrayList<String> ary = new ArrayList<String>();
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			
			if(map.get(str) == null) {
				continue;
			}
			
			cnt++;
			ary.add(str);
		}
		
		Collections.sort(ary);
		sb.append(cnt).append('\n');
		
		for (String data : ary) {
			sb.append(data).append('\n');
		}
		
		System.out.print(sb);
	}
}
