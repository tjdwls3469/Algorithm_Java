import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon16236 {
	public static int sharkSize = 2;
	public static boolean[][] check;
	public static int[][] map;
	public static int eatCnt;
	public static int ans;
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		int sx = 0;
		int sy = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		} // OK
		
		bfs(sx, sy);
		System.out.println(ans);
	} // end of main

	public static int[] dx = { -1, 0, 0, 1 };
	public static int[] dy = { 0, -1, 1, 0 };
	public static int nx, ny;
	
	private static void bfs(int x, int y) {
		PriorityQueue<Shark> q = new PriorityQueue<Shark>();
		check[x][y] = true;
		q.offer(new Shark(x, y, 0));
		
		Shark cur = null;
		while(!q.isEmpty()) {
			cur = q.peek();
			// 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
			if(map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < sharkSize) {
				eatCnt++;
				map[cur.x][cur.y] = 0; // 물고기를 먹으면, 그 칸은 빈 칸이 된다.
				if (eatCnt == sharkSize) { // 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
					sharkSize++;
					eatCnt = 0;
				}
				
				ans += cur.time;
				q.clear();
				for (int i = 0; i < N; i++) {
					Arrays.fill(check[i], false);
				}
				
				check[cur.x][cur.y] = true;
				q.offer(new Shark(cur.x, cur.y, 0));
			} // end of if
			cur = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				// 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny] && map[nx][ny] <= sharkSize) {
					check[nx][ny] = true;
					q.offer(new Shark(nx, ny, cur.time + 1));
				}
			}
		} // end of while
	} // end of bfs
} // end of class

class Shark implements Comparable<Shark> {
	public int x;
	public int y;
	public int time;
	
	public Shark(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
	
	@Override
	public int compareTo(Shark o) {
		// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
		if(this.time == o.time && this.x == o.x) {
			return this.y - o.y;
		}
		// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기를 먹는다.
		if(this.time == o.time) {
			return this.x - o.x;
		}
		// 거리가 가까운 물고기를 먹는다.
		return this.time - o.time;
	}
}
