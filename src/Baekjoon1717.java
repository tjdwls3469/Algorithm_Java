import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가지치기 제외 + 중복코드 제거
 */

public class Baekjoon1717 {
	public static int[] parents = new int[1000001];
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder ans = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = 0;
		int b = 0;
		int aRoot = 0;
		int bRoot = 0;
		int oper = 0;
		
		for (int i = 0; i <= n; i++) {		//makeSet
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			oper = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			aRoot = findSet(a);
			bRoot = findSet(b);
			
			if(oper == 1) {		// findSet
				if (aRoot == bRoot) {
					ans.append("YES").append('\n');
					continue;
				}
				ans.append("NO").append('\n');
				continue;
			}
			
			// 합집합
			if (aRoot == bRoot) {
				continue;
			}
			parents[bRoot] = aRoot;
		}
		
		System.out.print(ans);
	}	// end of main
	
	public static int findSet(int a) {		// path compression 적용
		if(parents[a] != a) {
			parents[a] = findSet(parents[a]);
		}
		return parents[a];
	}
}
