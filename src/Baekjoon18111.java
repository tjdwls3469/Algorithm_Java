import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max) {
					max = map[i][j];
				}
				if(map[i][j] < min) {
					min = map[i][j];
				}
			}
		}
		
		int time, Bcnt;
		int ansTime = Integer.MAX_VALUE;
		int ansHeight = 0;
		
		for (int h = max; h >= min; h--) {
			time = 0;
			Bcnt = B;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == h) {
						continue;
					}
					
					if(map[i][j] > h) {
						time += ((map[i][j] - h) * 2);
						Bcnt += map[i][j] - h;
					}else {
						time += h - map[i][j];
						Bcnt -= h - map[i][j];
					}
				}
			} // end of for
			
			if(Bcnt < 0) {
				continue;
			}
			
			if(time < ansTime) {
				ansTime = time;
				ansHeight = h;
			}
		} // end of for
		
		System.out.println(ansTime + " " + ansHeight);
	}
}
