import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15686 {
	private static int M, homeCnt, chickenCnt;
	private static int[] isSelected;
	public static Point[] homeAry, chickenAry;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		homeAry = new Point[2*N]; 
		chickenAry = new Point[13];
		isSelected = new int[13];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					homeAry[homeCnt++] = new Point(i, j);
					continue;
				}
				
				if(map[i][j] == 2) {
					chickenAry[chickenCnt++] = new Point(i, j);
				}
			}
		}
		
		combination(0, 0);
		System.out.println(ans);
	}
	
	public static int index, totalDist, ans;			
	
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			totalDist = 0;
			
			for (int i = 0; i < homeCnt; i++) {
				int dist = Integer.MAX_VALUE;
				int result = 0;
				
				for (int j = 0; j < M; j++) {
					index = isSelected[j];
					result = Math.abs(homeAry[i].x - chickenAry[index].x) + Math.abs(homeAry[i].y - chickenAry[index].y);
					
					if(result < dist) {
						dist = result;
					}
				}
				
				totalDist += dist;
			}
			
			if(ans == 0 || totalDist < ans) {
				ans = totalDist;
			}
			
			return;
		}
		
		for (int i = start; i < chickenCnt; i++) {
			isSelected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	static class Point {
		public int x;
		public int y;
		
		public Point() {
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
