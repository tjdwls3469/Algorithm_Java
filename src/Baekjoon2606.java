import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2606 {
	public static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int comCnt = Integer.parseInt(br.readLine());
		int pairCnt = Integer.parseInt(br.readLine());
		int size = comCnt + 1;
		
		parents = new int[size];
		for (int i = 1; i < size; i++) { // makeSet
			parents[i] = i;
		}
		
		int com1 = 0;
		int com2 = 0;
		int rootCom1 = 0;
		int rootCom2 = 0;
		StringTokenizer st;
		for (int i = 0; i < pairCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			com1 = Integer.parseInt(st.nextToken());
			com2 = Integer.parseInt(st.nextToken());
			rootCom1 = findSet(com1);
			rootCom2 = findSet(com2);
			if(rootCom1 != rootCom2) {
				if(rootCom1 == 1) {
					parents[rootCom2] = rootCom1;
				}else if(rootCom2 == 1) {
					parents[rootCom1] = rootCom2;
				}else {
					parents[rootCom2] = rootCom1;
				}
			}
		}
		
		int ans = 0;
		for (int i = 2; i < size; i++) {
			if(findSet(i) == 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static int findSet(int a) { // path compression
		if(parents[a] != a) {
			parents[a] = findSet(parents[a]);
		}
		return parents[a];
	}
}
