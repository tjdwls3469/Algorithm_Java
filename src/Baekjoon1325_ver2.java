import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1325_ver2 {
	public static int N, cnt;
	@SuppressWarnings("rawtypes")
	private static ArrayList[] adjMatrix;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adjMatrix = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjMatrix[i] = new ArrayList<Integer>();
		}

		check = new boolean[N + 1];
		int A, B;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			adjMatrix[B].add(A);
		}

		int[] ary = new int[N + 1];
		int max = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			dfs(i);
			ary[i] = cnt;

			if (cnt == max) {
				sb.append(i).append(' ');
			} else if (cnt > max) {
				max = cnt;
				sb.setLength(0);
				sb.append(i).append(' ');
			}

			cnt = 0;
			Arrays.fill(check, false);
		}

		System.out.println(sb);
	}

	public static boolean[] check;

	private static void dfs(int cur) {
		cnt++;
		check[cur] = true;

		int size = adjMatrix[cur].size();
		for (int i = 0; i < size; i++) {
			int next = (int) adjMatrix[cur].get(i);
			if (!check[next]) {
				dfs(next);
			}
		}
	}
}
