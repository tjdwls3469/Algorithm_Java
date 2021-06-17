import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon18352_ver2 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList[] adjList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Vertex>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A].add(new Vertex(B, 1));
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		
		dist[X] = 0;
		q.offer(new Vertex(X, 0));
		
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
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				sb.append(i).append('\n');
			}
		}
		
		if(sb.length() == 0) {
			System.out.println(-1);
		}else {
			System.out.print(sb);
		}
	}
	
}

class Vertex implements Comparable<Vertex> {
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
