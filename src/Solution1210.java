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

public class Solution1210 {
	public static final int SIZE = 100;
	public static final int XY = 3;
	public static final int[] dx = new int[] {0, 0, 1};
	public static final int[] dy = new int[] {-1, 1, 0};
	
	public static boolean bfs(int[][] ladder, int start) {
		boolean[][] check = new boolean[SIZE][SIZE];
		Queue<Pair> q = new LinkedList<Pair>();
		check[0][start] = true;
		q.offer(new Pair(0,start));
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int fx = p.x;
			int fy = p.y;
			for(int i=0;i<XY;i++) {
				int nx = fx + dx[i];
				int ny = fy + dy[i];
				if(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) {
					continue;
				}
				if(check[nx][ny] == false && ladder[nx][ny] == 1) {
					check[nx][ny] = true;
					q.offer(new Pair(nx,ny));
					break;
				}
				if(ladder[nx][ny] == 2) {
					return true;
				}
			}
		}
		return false;
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
			for(int j=0;j<SIZE;j++) {
				if(bfs(ladder, j) == true) {
					System.out.println("#" + i + " " + (j+1));
					break;
				}
			}
		}
	}
}
