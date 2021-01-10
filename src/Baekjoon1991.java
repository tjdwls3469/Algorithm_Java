import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1991 {
	public static StringBuilder sb = new StringBuilder();
	public static Pair[] nodes = new Pair[91];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		char node;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			node = st.nextToken().charAt(0);
			nodes[node] = new Pair(st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		
		preOrder('A');
		sb.append('\n');
		
		inOrder('A');
		sb.append('\n');
		
		postOrder('A');
		sb.append('\n');
		
		System.out.print(sb);
	}
	
	public static void preOrder(char cur) {
		if(cur == '.') {
			return;
		}
		sb.append(cur);
		preOrder(nodes[cur].left);
		preOrder(nodes[cur].right);
	}
	
	public static void inOrder(char cur) {
		if(cur == '.') {
			return;
		}
		inOrder(nodes[cur].left);
		sb.append(cur);
		inOrder(nodes[cur].right);
	}
	
	public static void postOrder(char cur) {
		if(cur == '.') {
			return;
		}
		postOrder(nodes[cur].left);
		postOrder(nodes[cur].right);
		sb.append(cur);
	}
	
	public static class Pair{
		public char left;
		public char right;
		
		public Pair(char left, char right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
}
