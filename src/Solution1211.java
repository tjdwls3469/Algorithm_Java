import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	public int x;
	public int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution1211 {
	public static final int SIZE = 100;
	public static final int XY = 3;
	public static final int[] dx = new int[] {0, 0, 1};
	public static final int[] dy = new int[] {-1, 1, 0};
	
	public static int bfs(int[][] ladder, int start) {
		boolean[][] check = new boolean[SIZE][SIZE];
		int dist = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		check[0][start] = true;
		q.offer(new Pair(0,start));
		int fx = 0;
		int fy = 0;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			fx = p.x;
			fy = p.y;
			for(int i=0;i<XY;i++) {
				int nx = fx + dx[i];
				int ny = fy + dy[i];
				if(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) {
					continue;
				}
				if(check[nx][ny] == false && ladder[nx][ny] == 1) {
					check[nx][ny] = true;
					q.offer(new Pair(nx,ny));
					dist++;
					break;
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] ladder = new int[SIZE][SIZE];
		for(int i=1;i<=10;i++) {
			sc.nextInt();
			for(int j=0;j<SIZE;j++) {
				for(int k=0;k<SIZE;k++) {
					ladder[j][k] = sc.nextInt();
				}
			}
			int min = Integer.MAX_VALUE;
			int ans = 0;
			for(int j=0;j<SIZE;j++) {
				if(ladder[0][j] != 1) {
					continue;
				}
				int result = bfs(ladder, j);
				if(result <= min) {
					min = result;
					ans = j;
				}
			}
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	}
}
