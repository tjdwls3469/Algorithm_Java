import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(st.nextToken(), true);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if(map.get(st.nextToken()) == null) {
				sb.append(0).append(' ');
				continue;
			}
			
			sb.append(1).append(' ');
		}
		
		System.out.println(sb);
	}
}
