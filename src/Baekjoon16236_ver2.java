import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon16236_ver2 {
	public static int sx;
	public static int sy;
	private static int N;
	private static int[][] map;
	private static boolean[][] check;
	private static int fishCnt;
	private static int sharkSize;
	public static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx= i;
					sy= j;
					map[i][j] = 0;
				}else if(map[i][j] != 0) {
					fishCnt++;
				}
			}
		}

		bfs(sx, sy);
		System.out.println(ans);
	}
	
//	public static Queue<int[]> q = new LinkedList<int[]>();
	public static PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] == o2[2]) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0]; 
			}
			return o1[2] - o2[2];
		}
	});
	public static PriorityQueue<int[]> temp = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] == o2[2]) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0]; 
			}
			return o1[2] - o2[2];
		}
	});
	public static int fx, fy, fd, nx, ny, nd;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static Shark shark = new Shark();
	
	private static void bfs(int x, int y) {
		
		check[x][y] = true;
		q.offer(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			
			if(!isRemain()) {
				System.out.println(ans);
				System.exit(0);
			}
			
			int qSize = q.size();
			
			for (int k = 0; k < qSize; k++) {
				fx = q.peek()[0];
				fy = q.peek()[1];
				fd = q.peek()[2];
				q.poll();
				
				sharkSize = shark.size;
				
				for (int i = 0; i < dx.length; i++) {
					nx = fx + dx[i];
					ny = fy + dy[i];
					nd = fd + 1;
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny] && map[nx][ny] <= sharkSize) {
						check[nx][ny] = true;
						q.offer(new int[] {nx, ny, nd});
					}
				}
			}
			
			boolean isEat = false;
			
			while(!q.isEmpty()) {
				fx = q.peek()[0];
				fy = q.peek()[1];
				fd = q.peek()[2];
				q.poll();
				
				if(map[fx][fy] >= sharkSize || map[fx][fy] == 0) {
					temp.offer(new int[] {fx, fy, fd});
					continue;
				}
				
				isEat = true;
				map[fx][fy] = 0;
				fishCnt--;
				shark.eatCnt++;
				if(shark.eatCnt == shark.size) {
					shark.size++;
					shark.eatCnt = 0;
				}
				
				ans = fd;
				
				if(fishCnt == 0) {
					System.out.println(ans);
					System.exit(0);
				}
				
				for (int j = 0; j < N; j++) {
					Arrays.fill(check[j], false);
				}
				
				q.clear();
				q.offer(new int[] {fx, fy, fd});
				
				break;
			}
			
			if(!isEat) {
				while(!temp.isEmpty()) {
					q.offer(temp.poll());
				}
			}
			temp.clear();
		}
	}
	
	public static boolean isRemain() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && map[i][j] < shark.size) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static class Shark {
		public int size = 2;
		public int eatCnt;
		
		public Shark() {
		}
	}
}
