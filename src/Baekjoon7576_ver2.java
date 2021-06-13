import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][col];
		Queue<int[]> q = new LinkedList<>();
		int zeroCnt = 0;
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					zeroCnt++;
					continue;
				}
				
				if(map[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
					continue;
				}
			}
		} // end of for
		
		boolean[][] check = new boolean[row][col];
		int[] cur;
		int fx, fy, cnt = 0;
		int nx, ny;
		
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				cur = q.poll();
				fx = cur[0];
				fy = cur[1];
				cnt = cur[2];
				
				for (int j = 0; j < dy.length; j++) {
					nx = fx + dx[j];
					ny = fy + dy[j];
					
					if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == 0 && !check[nx][ny]) {
						check[nx][ny] = true;
						q.offer(new int[] {nx, ny, cnt + 1});
						zeroCnt--;
					}
				}
			}
		}
		
		if(zeroCnt == 0) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	}
}
