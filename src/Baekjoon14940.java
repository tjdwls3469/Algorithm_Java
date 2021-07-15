import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14940 {
	private static boolean[][] check;
	private static int col, row;
	private static int[][] map, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		int x = 0;
		int y = 0;
		map = new int[row][col];
		check = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					x = i;
					y = j;
					continue;
				}
				
				if(map[i][j] == 0) {
					check[i][j] = true;
				}
			}
		}
		
		ans = new int[row][col];
		bfs(x, y);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(!check[i][j]) {
					sb.append(-1).append(' ');
					continue;
				}
				
				sb.append(ans[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		check[x][y] = true;
		q.offer(new int[] {x, y, 0});
		ans[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int fx = temp[0];
			int fy = temp[1];
			int cnt = temp[2];
			
			for (int i = 0; i < dx.length; i++) {
				int nx = fx + dx[i];
				int ny = fy + dy[i];
				int nCnt = cnt + 1;
				
				if(nx >= 0 && nx < row && ny >= 0 && ny < col && !check[nx][ny] && map[nx][ny] == 1) {
					check[nx][ny] = true;
					q.offer(new int[] {nx, ny, nCnt});
					ans[nx][ny] = nCnt;
				}
			}
		}
	}
}
