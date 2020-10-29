import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1249 {
	public static int[][] map = new int[100][100];
	public static boolean[][] check = new boolean[100][100];
	public static int N;
	public static int goal;
	public static StringBuilder sb = new StringBuilder();
	public static PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		String line;
		
		for (int tc = 1; tc <= C; tc++) {
			sb.append('#').append(tc).append(' ');
			N = Integer.parseInt(br.readLine());
			goal = N - 1;
			q.clear();
			
			for (int i = 0; i < N; i++) {
				line = br.readLine();
				
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			for (int i = 0; i < N; i++) {
				Arrays.fill(check[i], false);
			}
			check[0][0] = true;
			bfs(0, 0);
		}
		System.out.print(sb);
	}
	
	public static int[] dx = new int[] {0, -1, 0, 1};
	public static int[] dy = new int[] {-1, 0, 1, 0};
	public static int fx, fy, time, nx, ny;
	public static int[] cur;

	private static void bfs(int x, int y) {
		check[x][y] = true;
		q.offer(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			cur = q.peek();
			fx = cur[0];
			fy = cur[1];
			time = cur[2];
			q.poll();
			
			if(fx == goal && fy == goal) {
				sb.append(time).append('\n');
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny]) {
					check[nx][ny] = true;
					q.offer(new int[] {nx, ny, time + map[nx][ny]});
				}
			}
		}
	}
}
