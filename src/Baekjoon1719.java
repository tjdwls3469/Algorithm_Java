import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1719 {
	public static int[][] adjMatrix;
	public static boolean[] visited;
	public static int[] distance;
	public static int[] from;
	public static int min;
	public static int cur;
	public static int n;
	public static int result;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		distance = new int[n+1];
		from = new int[n+1];
		visited = new boolean[n+1];
		adjMatrix = new int[n+1][n+1];
		int a, b, w;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = adjMatrix[b][a] = w;
		}
		
		for (int start = 1; start <= n; start++) {
			dijkstra(start);
		}
		
		System.out.print(sb);
	}

	private static void dijkstra(int start) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		distance[start] = 0;
		from[start] = start;
		result = 0;
		
		for (int i = 1; i <= n; i++) {
			min = Integer.MAX_VALUE;
			
			for (int j = 1; j <= n; j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					cur = j;
				}
			} // end of for
			
			visited[cur] = true;
			
			for (int j = 1; j <= n; j++) {
				if(!visited[j] && adjMatrix[cur][j] != 0 && min + adjMatrix[cur][j] < distance[j]) {
					distance[j] = min + adjMatrix[cur][j];
					from[j] = cur;
				}
			}
		} // end of for
		
		// 출력
		int index = 0;
		for (int i = 1; i <= n; i++) {
			index = 0;
			for (int j = i; j != start; j = from[j]) {
				index = j;
			}
			
			if(index == 0) {
				sb.append('-').append(' ');
			}else {
				sb.append(index).append(' ');
			}
		}
		sb.append('\n');
	}
}
