import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ary = new int[N];
		int[] sortAry = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			sortAry[i] = ary[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sortAry);
		int cnt = 0;
		int pre = sortAry[0];
		map.put(sortAry[0], 0);
		
		for (int i = 1; i < N; i++) {
			if(sortAry[i] != pre) {
				cnt++;
				pre = sortAry[i];
			}
			
			map.put(sortAry[i], cnt);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(ary[i])).append(' ');
		}
		
		System.out.println(sb);
	}
}
