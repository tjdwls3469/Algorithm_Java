import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1949 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[8][8];
		int[][][] check = new int[8][8][2];
		int N = 0;
		int K = 0;
		int max = Integer.MIN_VALUE;
		String line = "";
		

		for (int tc = 1; tc <= T; tc++) {
			line = br.readLine();
			N = line.charAt(0) - '0';
			K = line.charAt(2) - '0';

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) {
						max = map[i][j];
					}
				}
			}

			Queue<int[]> startPoint = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						startPoint.offer(new int[] { i, j });
					}
				}
			}
			
			while(!startPoint.isEmpty()) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 8; j++) {
						for (int k = 0; k < 8; k++) {
							check[i][j][k] = 0;
						}
					}
				}
				
				Queue<Land> q = new LinkedList<Land>();
				int fx = startPoint.peek()[0];
				int fy = startPoint.peek()[1];
				startPoint.poll();
				
				check[fx][fy][0] = 1;
				q.offer(new Land(fx, fy, 0));
				
				while(!q.isEmpty()) {
					fx = q.peek().x;
					fy = q.peek().y;
					q.poll();
				}
			} // end of while
		} // end of tc
	} // end of main
}
class Land {
	public int x;
	public int y;
	public int workCnt;
	
	public Land(int x, int y, int workCnt) {
		super();
		this.x = x;
		this.y = y;
		this.workCnt = workCnt;
	}
}
