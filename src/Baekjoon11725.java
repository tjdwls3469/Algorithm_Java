import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11725 {
	@SuppressWarnings("rawtypes")
	private static ArrayList[] adjList;
	private static boolean[] check;
	private static int[] ans;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ans = new int[N+1];
		check = new boolean[N+1];
		adjList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(ans[i]).append('\n');
		}
		System.out.print(sb);
	}

	private static void dfs(int cur) {
		check[cur] = true;
		
		for (int i = 0; i < adjList[cur].size(); i++) {
			int next = (int) adjList[cur].get(i);
			
			if(!check[next]) {
				ans[next] = cur;
				dfs(next);
			}
		}
	}
}