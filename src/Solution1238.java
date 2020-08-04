import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1238 {
	public static boolean[][] map = new boolean[101][101];
	public static int[] check = new int[101];
	public static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();
		int start = 0;
		int from = 0;
		int to = 0;
		int maxIndex = 0;
		int maxVal = 0;;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			cnt = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < cnt; i += 2) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				if(map[from][to]) {
					continue;
				}
				map[from][to] = true;
			}
			bfs(start);
			maxIndex = -1;
			maxVal = -1;
			for (int i = 0; i < check.length; i++) {
				if(maxVal == -1 || check[i] >= maxVal) {
					maxVal = check[i];
					maxIndex = i;
				}
				check[i] = 0;
				for (int j = 0; j < 101; j++) {
					map[i][j] = false;
				}
			}
			ans.append('#').append(tc).append(' ').append(maxIndex).append('\n');
		}	// end of tc
		System.out.print(ans);
	}	// end of main

	public static int front;
	public static int rear;
	public static int[] q = new int[100];
	public static void bfs(int start) {
		front = -1;
		rear = -1;
		check[start] = 1;
		q[++rear] = start;
		int preNode = 0;
		while(front != rear) {
			preNode = q[++front];
			for (int i = 0; i < check.length; i++) {
				if(map[preNode][i] && check[i] == 0) {
					check[i] = check[preNode] + 1;
					q[++rear] = i;
				}
			}
		}
	}
}
