import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon4386 {
	public static int[] parents;
	public static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		Point[] star = new Point[n];
		parents = new int[n];
		
		double x, y;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Double.parseDouble(st.nextToken());
			y = Double.parseDouble(st.nextToken());
			
			star[i] = new Point(x, y);
		}
		
		ArrayList<Edge> list = new ArrayList<>();
		double weigt;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				
				weigt = Math.sqrt(Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2));
				list.add(new Edge(i, j, weigt));
			}
		}
		
		Collections.sort(list);
		makeSet();
		
		double ans = 0;
		int cnt = 0;
		int size = list.size();
		Edge cur;
		for (int i = 0; i < size; i++) {
			cur = list.get(i);
			
			if(unionFind(cur.from, cur.to)) {
				cnt++;
				ans += cur.weigt;
				
				if(cnt == n-1) {
					break;
				}
			}
		} // end of for
		System.out.format("%.2f", ans);
	} // end of main
	
	public static void makeSet() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	public static int findset(int a) {
		if(parents[a] != a) {
			parents[a] = findset(parents[a]);
		}
		
		return parents[a];
	}
	
	public static boolean unionFind(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static class Point {
		public double x;
		public double y;
		
		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		public int from;
		public int to;
		public double weigt;
		
		public Edge(int from, int to, double weigt) {
			super();
			this.from = from;
			this.to = to;
			this.weigt = weigt;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weigt, o.weigt);
		}
	}
}