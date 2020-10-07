import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon19238 {
	private static int N;
	private static int M;
	private static int fuel;
	private static int[][] map;
	public static HashMap<Integer, int[]> hm = new HashMap<Integer, int[]>();
	private static boolean[][] check;
	public static int goal;
	public static int pairCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		check = new boolean[N+1][N+1];
		qx = new int[N*N];
		qy = new int[N*N];
		qd = new int[N*N];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x, y;
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int end = M + 2;
		for (int i = 2; i < end; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
			hm.put(i, new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		pairCnt = M;
		bfs(x,y);
		
		if(pairCnt > 0) {
			System.out.println(-1);
		}
	}
	
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	
	public static int frontX, rearX, frontY, rearY, frontD, rearD;
	public static int[] qx;
	public static int[] qy;
	public static int[] qd;
	
	public static int fx, fy, nx, ny, fd, nd;

	public static void bfs(int x, int y) {
		for (int i = 1; i < check.length; i++) {
			Arrays.fill(check[i], false);
		}
		frontX = rearX = frontY = rearY = frontD = rearD = -1;
		
		check[x][y] = true;
		qx[++rearX] = x;
		qy[++rearY] = y;
		qd[++rearD] = 0;
		
		while(rearX != frontX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			fd = qd[++frontD];
//			print();
//			System.out.println(fx + " " + fy);
			
			if(map[fx][fy] > 1) {
				
				fuel -= fd;
				if(fuel < 0) {
					System.out.println(-1);
					System.exit(0);
				}
				
				goal = map[fx][fy];
				map[fx][fy] = 0;
//				System.out.println("bfs");
//				System.out.println("fuel: " + fuel);
				
				bfs2(fx, fy);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				nd = fd + 1;
				
				if(nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] != 1 && !check[nx][ny]) {
					check[nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					qd[++rearD] = nd;
				}
			}
		}
	}

	private static void bfs2(int x, int y) {
		for (int i = 1; i < check.length; i++) {
			Arrays.fill(check[i], false);
		}
		frontX = rearX = frontY = rearY = frontD = rearD = -1;
		
		check[x][y] = true;
		qx[++rearX] = x;
		qy[++rearY] = y;
		qd[++rearD] = 0;
		
		while(rearX != frontX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			fd = qd[++frontD];
//			print();
//			System.out.println(fx + " " + fy);
			
//			if(map[fx][fy] == goal) {
			if(hm.get(goal)[0] == fx && hm.get(goal)[1] == fy) {
				fuel -= fd;
				if(fuel < 0) {
					System.out.println(-1);
					System.exit(0);
				}
				
				fuel += fd*2;
				
				pairCnt--;
//				System.out.println("bfs2");
//				System.out.println("fuel: " + fuel);
//				System.out.println("pairCnt: " + pairCnt);
				if(pairCnt == 0) {
					System.out.println(fuel);
//					System.out.println("들어옴");
					System.exit(0);
				}
				
				bfs(fx, fy);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				nd = fd + 1;
				
				if(nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] != 1 && !check[nx][ny]) {
					check[nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					qd[++rearD] = nd;
				}
			}
		}
	}
	
	public static void print() {
		System.out.println();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
