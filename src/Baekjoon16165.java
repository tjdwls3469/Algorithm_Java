import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon16165 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, ArrayList<String>> map2 = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String group = br.readLine();
			int memberCnt = Integer.parseInt(br.readLine());
			
			ArrayList<String> list = new ArrayList<>();
			for (int j = 0; j < memberCnt; j++) {
				String name = br.readLine();
				map1.put(name, group);
				list.add(name);
			}
			
			Collections.sort(list);
			map2.put(group, list);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			int num = Integer.parseInt(br.readLine());
			
			if(num == 1) {
				sb.append(map1.get(str)).append('\n');
				continue;
			}
			
			ArrayList<String> temp = map2.get(str);
			for (String member : temp) {
				sb.append(member).append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
