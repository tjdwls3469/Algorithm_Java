import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17836 {
	private static int N, M, T;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		check1 = new boolean[N][M];
		check2 = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = bfs(0, 0);
		if(time > T) {
			System.out.println("Fail");
		}else {
			System.out.println(time);
		}
	}
	
	public static boolean[][] check1, check2;
	public static int[] dx = new int[] {0, -1, 0, 1};
	public static int[] dy = new int[] {-1, 0, 1, 0};

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		check1[x][y] = true;
		q.offer(new int[] {x, y, 0, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int fx = cur[0];
			int fy = cur[1];
			int cnt = cur[2];
			int exist = cur[3];
			
			if(fx == N - 1 && fy == M - 1) {
				return cnt;
			}
			
			if(exist == 0) {
				for (int i = 0; i < 4; i++) {
					int nx = fx + dx[i];
					int ny = fy + dy[i];
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !check1[nx][ny]) {
						check1[nx][ny] = true;
						q.offer(new int[] {nx, ny, cnt + 1, 0});
					}
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 2 && !check1[nx][ny]) {
						check1[nx][ny] = true;
						check2[nx][ny] = true;
						q.offer(new int[] {nx, ny, cnt + 1, 1});
					}
				}
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = fx + dx[i];
				int ny = fy + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !check2[nx][ny]) {
					check2[nx][ny] = true;
					q.offer(new int[] {nx, ny, cnt + 1, 1});
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}
}
