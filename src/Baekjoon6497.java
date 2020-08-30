import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon6497 {
	public static int[] parents = new int[200000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int m, n, total, x, y, z, cnt, sum, xRoot, yRoot;
		m = n = total = x = y = z = cnt = sum = xRoot = yRoot = 0;
		Edg cur = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0) {
				break;
			}
			
			total = 0;
			ArrayList<Edg> list = new ArrayList<Edg>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());
				list.add(new Edg(x, y, z));
				total += z;
			}
			
			Collections.sort(list);
			
			for (int i = 0; i < m; i++) {
				parents[i] = i;
			}
			
			cnt = 0;
			sum = 0;
			
			for (int i = 0; i < n; i++) {
				cur = list.get(i);
				xRoot = findSet(cur.x);
				yRoot = findSet(cur.y);
				
				if(xRoot == yRoot) {
					continue;
				}
				
				parents[yRoot] = xRoot;
				sum += cur.z;
				if(++cnt >= m - 1) {
					break;
				}
			}
			sb.append(total - sum).append('\n');
		}	// end of while
		System.out.print(sb);
	}	// end of main
	
	public static int findSet(int a) {
		if(parents[a] != a) {
			parents[a] = findSet(parents[a]);
		}
		return parents[a];
	}
}

class Edg implements Comparable<Edg>{
	public int x;
	public int y;
	public int z;
	
	public Edg() {

	}

	public Edg(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public int compareTo(Edg o) {
		return Integer.compare(this.z, o.z);
	}

	@Override
	public String toString() {
		return "Edge [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
