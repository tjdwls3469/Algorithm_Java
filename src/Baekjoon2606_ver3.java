import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2606_ver3 {
	private static boolean[] check;
	@SuppressWarnings("rawtypes")
	private static ArrayList[] adjList;
	private static int ans;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		check = new boolean[N+1];
		adjList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		dfs(1);
		System.out.println(ans);
	}

	private static void dfs(int cur) {
		check[cur] = true;
		
		for (int i = 0; i < adjList[cur].size(); i++) {
			int next = (int) adjList[cur].get(i);
			if(!check[next]) {
				ans++;
				dfs(next);
			}
		}
	}
}
