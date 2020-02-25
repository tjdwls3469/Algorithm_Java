import java.util.Scanner;

public class Solution1219 {
	public static final int TC = 10;
	public static final int CNT = 100;
	
	public static void dfs(int start, int[] vertex1, int[] vertex2, boolean[] check) {
		check[start] = true;
		int node1 = vertex1[start];
		if(check[node1] == false) {
			dfs(node1, vertex1, vertex2, check);
		}
		int node2 = vertex2[start];
		if(check[node2] == false) {
			dfs(node2, vertex1, vertex2, check);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = 0;
		for(int i=1;i<=TC;i++) {
			int[] vertex1 = new int[CNT];
			int[] vertex2 = new int[CNT];
			boolean[] check = new boolean[CNT];
			int index;
			int val;
			sc.nextInt();
			len = sc.nextInt();
			for(int j=0;j<len;j++) {
				index = sc.nextInt();
				val = sc.nextInt();
				if(vertex1[index] == 0) {
					vertex1[index] = val;
				}else {
					vertex2[index] = val;
				}
			}
			dfs(0,vertex1,vertex2,check);
			if(check[99] == true) {
				System.out.println("#" + i + " " + 1);
			}else {
				System.out.println("#" + i + " " + 0);
			}
		}
	}
}
