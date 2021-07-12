import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int cntA = Integer.parseInt(st.nextToken());
		int cntB = Integer.parseInt(st.nextToken());
		int[] aryA = new int[cntA];
		int[] aryB = new int[cntB];
		Map<Integer, Boolean> mapA = new HashMap<>();
		Map<Integer, Boolean> mapB = new HashMap<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < cntA; i++) {
			aryA[i] = Integer.parseInt(st.nextToken());
			mapA.put(aryA[i], true);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < cntB; i++) {
			aryB[i] = Integer.parseInt(st.nextToken());
			mapB.put(aryB[i], true);
		}
		
		int ans = 0;
		for (int i = 0; i < cntA; i++) {
			if(mapB.get(aryA[i]) == null) {
				ans++;
			}
		}
		for (int i = 0; i < cntB; i++) {
			if(mapA.get(aryB[i]) == null) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
