import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon4485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		int[][] map = new int[125][125];
		int[][] dist = new int[125][125];
		String str;
		int N;
		int cnt = 0;
		
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			q.clear();
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				
				for (int j = 0, index = 0; j < N; j++, index+=2) {
					map[i][j] = str.charAt(index) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dist[0][0] = map[0][0];
			q.offer(new Vertex(0, 0, map[0][0]));
			
			Vertex cur;
			int nx, ny;
			while(!q.isEmpty()) {
				cur = q.poll();
				
				if(dist[cur.x][cur.y] != cur.dist) {
					continue;
				}
				
				for (int i = 0; i < dx.length; i++) {
					nx = cur.x + dx[i];
					ny = cur.y + dy[i];
					
					if(nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] > cur.dist + map[nx][ny]) {
						dist[nx][ny] = cur.dist + map[nx][ny];
						q.offer(new Vertex(nx, ny, dist[nx][ny]));
					}
				}
			} // end of dijkstra
			sb.append("Problem ").append(++cnt).append(':').append(' ').append(dist[N-1][N-1]).append('\n');
		} // end of while
		System.out.print(sb);
	}
	
	static class Vertex implements Comparable<Vertex> {
		public int x;
		public int y;
		public int dist;
		
		public Vertex(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.dist - o.dist;
		}
	}
}
