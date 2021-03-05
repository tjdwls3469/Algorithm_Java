import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1504 {
	private static int N;
	@SuppressWarnings("rawtypes")
	private static ArrayList[] adjList;

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Vertex>();
		}
		
		int a, b, c;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Vertex(b, c));
			adjList[b].add(new Vertex(a, c));
		}
		
		int v1, v2;
		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int[] dist1, dist2, dist3;
		long ans1, ans2;
		ans1 = ans2 = 0;
		
		dist1 = dijkstra(1);
		dist2 = dijkstra(v1);
		dist3 = dijkstra(v2);
		
		ans1 += dist1[v1] + dist2[v2] + dist3[N];
		ans2 += dist1[v2] + dist3[v1] + dist2[N];
		
		if(ans1 >= Integer.MAX_VALUE && ans2 >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(Long.min(ans1, ans2));
		}
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		dist[start] = 0;
		q.offer(new Vertex(start, 0));
		
		Vertex cur, next;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(dist[cur.no] != cur.dist) {
				continue;
			}
			
			for (int i = 0; i < adjList[cur.no].size(); i++) {
				next = (Vertex) adjList[cur.no].get(i);
				
				if(dist[next.no] > cur.dist + next.dist) {
					dist[next.no] = cur.dist + next.dist;
					q.offer(new Vertex(next.no, dist[next.no]));
				}
			}
		}
		
		return dist;
	}
	
	static class Vertex implements Comparable<Vertex> {
		public int no;
		public int dist;
		
		public Vertex(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.dist - o.dist;
		}
	}
}
