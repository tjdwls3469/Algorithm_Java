import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1389 {
	public static boolean[][] map;
	public static boolean[] check;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		check = new boolean[N+1];
		q = new int[N*N];
		qd = new int[N*N];
		int A, B;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			map[A][B] = map[B][A] = true;
		}
		
		int cnt;
		int minCnt = Integer.MAX_VALUE;
		int ans = 0;
		for (int start = 1; start <= N; start++) {
			cnt = 0;
			
			for (int end = 1; end <= N; end++) {
				if(start == end) {
					continue;
				}
				
				cnt += bfs(start, end);
			}
			
			if(cnt < minCnt) {
				minCnt = cnt;
				ans = start;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int[] q;
	public static int[] qd;
	public static int front, rear, frontD, rearD, cur, dist;

	public static int bfs(int start, int end) {
		Arrays.fill(check, false);
		front = rear = frontD = rearD = -1;
		
		check[start] = true;
		q[++rear] = start;
		qd[++rearD] = 0;
		
		while(front != rear) {
			cur = q[++front];
			dist = qd[++frontD];
			
			if(cur == end) {
				return dist;
			}
			
			for (int i = 1; i <= N; i++) {
				if(map[cur][i] && !check[i]) {
					check[i] = true;
					q[++rear] = i;
					qd[++rearD] = dist + 1;
				}
			}
		}
		
		return 0;
	}
}
