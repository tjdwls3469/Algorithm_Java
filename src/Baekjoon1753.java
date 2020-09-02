import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1753 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] list = new ArrayList[V + 1];
		int[] distance = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		int u, v, w;
		u = v = w = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if(list[u] == null) {
				list[u] = new ArrayList<Node>();
			}
			list[u].add(new Node(v, w));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(K, 0));
		distance[K] = 0;
		
		Node cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(list[cur.no] == null) continue;
			
			for (Node next : list[cur.no]) {
				if(next.weight + distance[cur.no] < distance[next.no]) {
					distance[next.no] = next.weight + distance[cur.no];
					q.offer(new Node(next.no, distance[next.no]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append('\n');
				continue;
			}
			sb.append(distance[i]).append('\n');
		}
		System.out.print(sb);
	}
}

class Node implements Comparable<Node>{
	public int no;
	public int weight;
	
	public Node(int no, int weight) {
		this.no = no;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}
