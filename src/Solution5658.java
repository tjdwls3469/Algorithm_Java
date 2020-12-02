import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution5658 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder hexSb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, K;
		int rotationCnt;
		char endChar;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			char[] hexAry = br.readLine().toCharArray();
			rotationCnt = N / 4;
			endChar = hexAry[N-1];
			set.clear();
			
			// 데이터를 N/4 개씩 나누어서 set에 넣기
			for (int i = 0; i < N; i+=N/4) {
				hexSb.setLength(0);
				for (int j = i; j < i+N/4; j++) {
					hexSb.append(hexAry[j]);
				}
				set.add(Integer.parseInt(hexSb.toString(), 16));
			}
			
			for (int k = 1; k < rotationCnt; k++) {
				endChar = hexAry[N-1];
				System.arraycopy(hexAry, 0, hexAry, 1, N-1);
				hexAry[0] = endChar;
				
				for (int i = 0; i < N; i+=N/4) {
					hexSb.setLength(0);
					for (int j = i; j < i+N/4; j++) {
						hexSb.append(hexAry[j]);
					}
					set.add(Integer.parseInt(hexSb.toString(), 16));
				}
			}
			
			List ansList = new ArrayList(set);
			Collections.sort(ansList, Comparator.reverseOrder());
			sb.append('#').append(tc).append(' ').append(ansList.get(K-1)).append('\n');
		} // end of tc
		System.out.println(sb);
	}
}
