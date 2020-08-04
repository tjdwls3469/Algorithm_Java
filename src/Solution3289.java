import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3289 {
	public static int[] parent = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		int n = 0;
		int m = 0;
		int a = 0;
		int b = 0;
		int check = 0;
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();
		
		for (int tc = 1; tc <= testCase; tc++) {
			ans.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				check = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(check == 0) {
					union(a,b);
					continue;
				}
				ans.append(findSet(a) == findSet(b) ? 1 : 0);
			}
			ans.append('\n');
		}	// end of tc
		System.out.print(ans);
	}	// end of main
	
	public static int findSet(int a) {
		if(parent[a] != a) {
			parent[a] = findSet(parent[a]);
		}
		return parent[a];
	}
	
	public static void union(int a, int b) {
		int rootA = findSet(a);
		int rootb = findSet(b);
		if(rootA == rootb) {
			return;
		}
		parent[rootb] = rootA;
	}
}	// end of class
