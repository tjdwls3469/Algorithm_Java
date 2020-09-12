import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2606 {
	public static int comCnt;
	public static boolean[][] adjMatrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comCnt = Integer.parseInt(br.readLine());
		int pairCnt = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[comCnt + 1][comCnt + 1];
		
		int com1 = 0;
		int com2 = 0;
		StringTokenizer st;
		for (int i = 0; i < pairCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			com1 = Integer.parseInt(st.nextToken());
			com2 = Integer.parseInt(st.nextToken());
			adjMatrix[com1][com2] = adjMatrix[com2][com1] = true;
		}
		
		check = new boolean[comCnt + 1];
		dfs(1);
		System.out.println(ans);
	}

	public static boolean[] check;
	public static int ans;
	
	public static void dfs(int cur) {
		check[cur] = true;
		
		for (int next = 1; next <= comCnt; next++) {
			if(!check[next] && adjMatrix[cur][next]) {
				check[next] = true;
				ans++;
				dfs(next);
			}
		}
	}
}
