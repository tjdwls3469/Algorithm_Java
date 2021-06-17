import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1717_ver2 {
	public static int[] parents = new int[1000001];
	private static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		make();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int aRoot = findSet(a);
			int bRoot = findSet(b);
			
			if(command == 0) {
				if(aRoot != bRoot) {
					parents[bRoot] = aRoot;
				}
				
				continue;
			}
			
			if(aRoot == bRoot) {
				sb.append("YES").append('\n');
				continue;
			}
			
			sb.append("NO").append('\n');
		}
		System.out.println(sb);
	}

	private static int findSet(int a) {
		if(parents[a] != a) {
			parents[a] = findSet(parents[a]);
		}
		
		return parents[a];
	}

	private static void make() {
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
}
