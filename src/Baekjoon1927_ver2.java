import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1927_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();

		int x;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());

			if (x != 0) {
				q.offer(x);
				continue;
			}

			if (q.isEmpty()) {
				sb.append(0).append('\n');
				continue;
			}

			sb.append(q.poll()).append('\n');
		}

		System.out.print(sb);
	}
}
