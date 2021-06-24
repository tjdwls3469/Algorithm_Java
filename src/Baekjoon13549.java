import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon13549 {
	private static boolean[] check = new boolean[100001];
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		System.out.println(bfs(N));
	}

	private static int bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		check[start] = true;
		q.offer(new int[] { start, 0 });

		while (!q.isEmpty()) {
			int size = q.size();
			for (int t = 0; t < size; t++) {
				int[] ary = q.poll();
				int cur = ary[0];
				int cnt = ary[1];
				
				if(cur == K) {
					return cnt;
				}
				
				if(cur * 2 <= 100000 && !check[cur * 2]) {
					check[cur * 2] = true;
					q.offer(new int[] {cur * 2, cnt});
				}
				
				if(cur - 1 >= 0 && !check[cur - 1]) {
					check[cur - 1] = true;
					q.offer(new int[] {cur - 1, cnt + 1});
				}
				
				if(cur + 1 <= 100000 && !check[cur + 1]) {
					check[cur + 1] = true;
					q.offer(new int[] {cur + 1, cnt + 1});
				}
			}
		}
		
		return 0;
	}
}
