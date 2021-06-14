import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1913 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int cnt = 1;
		map[N/2 + 1][N/2 + 1] = cnt;
		int startX = N/2 + 1;
		int startY = N/2 + 1;
		int ansX = 1;
		int ansY = 1;
		
		for (int t = 0; t < N/2; t++) {
			startX--;
			startY--;
			cnt += 2;
			
			int x = startX;
			int y = startY;
			int startNum = (int) Math.pow(cnt, 2);
			map[x][y] = startNum;
			
			for (int i = 1; i < cnt; i++) {
				map[++x][y] = --startNum;
				
				if(startNum == num) {
					ansX = x;
					ansY = y;
				}
			}
			for (int i = 1; i < cnt; i++) {
				map[x][++y] = --startNum;
				
				if(startNum == num) {
					ansX = x;
					ansY = y;
				}
			}
			for (int i = 1; i < cnt; i++) {
				map[--x][y] = --startNum;
				
				if(startNum == num) {
					ansX = x;
					ansY = y;
				}
			}
			for (int i = 2; i < cnt; i++) {
				map[x][--y] = --startNum;
				
				if(startNum == num) {
					ansX = x;
					ansY = y;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		sb.append(ansX).append(' ').append(ansY);
		System.out.print(sb);
	}
}
