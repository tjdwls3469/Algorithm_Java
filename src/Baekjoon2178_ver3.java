import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178_ver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] map = new String[N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		boolean[][] check = new boolean[N][M];
		
		Queue<int[]> q = new LinkedList<int[]>();
		check[0][0] = true;
		q.offer(new int[] {0, 0, 1});
		
		int[] cur;
		int fx, fy, cnt = 0;
		int nx, ny;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			fx = cur[0];
			fy = cur[1];
			cnt = cur[2];
			
			if(fx == N-1 && fy == M-1) {
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !check[nx][ny] && map[nx].charAt(ny) == '1') {
					check[nx][ny] = true;
					q.offer(new int[] {nx, ny, cnt + 1});
				}
			}
		}
		
		System.out.println(cnt);
	}
}
