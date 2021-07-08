import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2578 {
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] call = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				call[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
ex:		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ans++;
				convertZero(call[i][j]);
				
				int cnt = 0;
				if(map[0][0] == 0 && map[0][1] == 0 && map[0][2] == 0 && map[0][3] == 0 && map[0][4] == 0) {
					cnt++;
				}
				if(map[1][0] == 0 && map[1][1] == 0 && map[1][2] == 0 && map[1][3] == 0 && map[1][4] == 0) {
					cnt++;
				}
				if(map[2][0] == 0 && map[2][1] == 0 && map[2][2] == 0 && map[2][3] == 0 && map[2][4] == 0) {
					cnt++;
				}
				if(map[3][0] == 0 && map[3][1] == 0 && map[3][2] == 0 && map[3][3] == 0 && map[3][4] == 0) {
					cnt++;
				}
				if(map[4][0] == 0 && map[4][1] == 0 && map[4][2] == 0 && map[4][3] == 0 && map[4][4] == 0) {
					cnt++;
				}
				
				if(map[0][0] == 0 && map[1][0] == 0 && map[2][0] == 0 && map[3][0] == 0 && map[4][0] == 0) {
					cnt++;
				}
				if(map[0][1] == 0 && map[1][1] == 0 && map[2][1] == 0 && map[3][1] == 0 && map[4][1] == 0) {
					cnt++;
				}
				if(map[0][2] == 0 && map[1][2] == 0 && map[2][2] == 0 && map[3][2] == 0 && map[4][2] == 0) {
					cnt++;
				}
				if(map[0][3] == 0 && map[1][3] == 0 && map[2][3] == 0 && map[3][3] == 0 && map[4][3] == 0) {
					cnt++;
				}
				if(map[0][4] == 0 && map[1][4] == 0 && map[2][4] == 0 && map[3][4] == 0 && map[4][4] == 0) {
					cnt++;
				}
				
				if(map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0 && map[3][3] == 0 && map[4][4] == 0) {
					cnt++;
				}
				if(map[4][0] == 0 && map[3][1] == 0 && map[2][2] == 0 && map[1][3] == 0 && map[0][4] == 0) {
					cnt++;
				}
				
				if(cnt >= 3) {
					break ex;
				}
			}
		} // end of for
		
		System.out.println(ans);
	}

	private static void convertZero(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == num) {
					map[i][j] = 0;
					return;
				}
			}
		}
	}
}
