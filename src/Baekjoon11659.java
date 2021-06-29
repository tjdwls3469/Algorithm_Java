import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] ary = new int[N + 1];
		int[] sum = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + ary[i];
		}

		int left, right;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());

			sb.append(sum[right] - sum[left - 1]).append('\n');
		}
		System.out.println(sb);
	}
}