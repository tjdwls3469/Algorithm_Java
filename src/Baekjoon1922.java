import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1922 {
	public static int N;
	public static int M;
	public static int[] parents = new int[1002];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		int a;
		int b;
		int c;
		StringTokenizer st;
		Edge6497[] list = new Edge6497[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list[i] = new Edge6497(a, b, c);
		}
		
		Arrays.sort(list);
		make();
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if(union(list[i].from, list[i].to)) {
				sum += list[i].weight;
				if(++cnt == N-1) {
					break;
				}
			}
		}
		System.out.println(sum);
	}
	
	public static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] != a) {
			parents[a] = findSet(parents[a]);
		}
		return parents[a];
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}

class Edge implements Comparable<Edge6497> {
	public int from;
	public int to;
	public int weight;
	
	public Edge() {

	}

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge6497 o) {
		return this.weight - o.weight;
	}
}
