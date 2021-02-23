import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2606_ver2 {
	public static boolean[] check;
	public static int N, ans;
	public static boolean[][] adjMatrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		check = new boolean[N + 1];

		int a, b;
		StringTokenizer st;
		adjMatrix = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			adjMatrix[a][b] = adjMatrix[b][a] = true;
		}

		dfs(1);
		System.out.println(ans - 1);
	}

	public static void dfs(int cur) {
		check[cur] = true;
		ans++;

		for (int i = 1; i <= N; i++) {
			if (adjMatrix[cur][i] && !check[i]) {
				dfs(i);
			}
		}
	}
}
