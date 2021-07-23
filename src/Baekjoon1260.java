import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260 {
	private static ArrayList[] adjList;
	private static boolean[] check;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		check = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(V);
		Arrays.fill(check, false);
		sb.append('\n');
		
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		check[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(' ');
			
			for (int i = 0; i < adjList[cur].size(); i++) {
				int next = (int) adjList[cur].get(i);
				if(check[next]) {
					continue;
				}
				
				check[next] = true;
				q.offer(next);
			}
		}
	}

	private static void dfs(int cur) {
		check[cur] = true;
		sb.append(cur).append(' ');
		
		for (int i = 0; i < adjList[cur].size(); i++) {
			int next = (int) adjList[cur].get(i);
			if(check[next]) {
				continue;
			}
			
			dfs(next);
		}
	}
}
