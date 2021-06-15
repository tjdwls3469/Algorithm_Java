import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16918 {
	private static int R, C;
	private static char[][] map;
	private static int[][] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		time = new int[R][C];
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			int len = row.length();
			
			for (int j = 0; j < len; j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j] == 'O') {
					time[i][j] = 3;
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if(i % 2 == 0) {
				bombInstallation(i);
				continue;
			}
			
			bombExplosion(i);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};

	private static void bombExplosion(int curTime) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.' || time[i][j] != curTime) {
					continue;
				}
				
				for (int t = 0; t < dx.length; t++) {
					int nx = i + dx[t];
					int ny = j + dy[t];
					
					if(nx >= 0 && nx < R && ny >= 0 && ny < C && time[nx][ny] != curTime) {
						map[nx][ny] = '.';
						time[nx][ny] = 0;
					}
				}
				
				map[i][j] = '.';
				time[i][j] = 0;
			}
		}
	}

	private static void bombInstallation(int curTime) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'O') {
					continue;
				}
				
				map[i][j] = 'O';
				time[i][j] = curTime + 3;
			}
		}
	}
}
