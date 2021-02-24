import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] check = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int zeroCnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					zeroCnt++;
				}else if(map[i][j] == 1) {
					check[i][j] = true;
					q.offer(new int[] {i, j});
				}
			}
		}
		
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		int[] cur;
		int nx, ny, size;
		int ans = 0;
		
		while(!q.isEmpty()) {
			ans++;
			size = q.size();
			
			for (int k = 0; k < size; k++) {
				cur = q.poll();
				
				for (int i = 0; i < dx.length; i++) {
					nx = cur[0] + dx[i];
					ny = cur[1] + dy[i];
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !check[nx][ny]) {
						check[nx][ny] = true;
						q.offer(new int[] {nx, ny});
						zeroCnt--;
					}
				}
			}
		}
		
		if(zeroCnt == 0) {
			System.out.println(ans - 1);
		}else {
			System.out.println(-1);
		}
	}
}
