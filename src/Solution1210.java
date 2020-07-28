import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 마지막 행을 순회하면서 도착지점 '2'를 찾는다
 * 도착지점에서 시작하여 위로 올라가서 출발점을 찾는다
 */

public class Solution1210 {
	public static int[] dx = {0, 0, -1};
	public static int[] dy = {-1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		char[][] map = new char[100][100];
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();	// 테스트 케이스 번호
			
			boolean[][] check = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j = 0;
				while(st.hasMoreTokens()) {
					map[i][j++] = st.nextToken().charAt(0);
				}
			}
			
			int fx = 99;
			int fy = 0;
			for (int i = 0; i < 100; i++) {
				if(map[99][i] == '2') {
					fy = i;
					break;
				}
			}
			
			boolean isGoal = false;
			while(true) {
				for (int i = 0; i < 3; i++) {
					int nx = fx + dx[i];
					int ny = fy + dy[i];
					if(nx >= 0 && ny >= 0 && ny <100) {
						if(map[nx][ny] == '1' && check[nx][ny] == false) {
							check[nx][ny] = true;
							fx = nx;
							fy = ny;
							if(fx == 0) {
								isGoal = true;
								ans.append("#" + tc + " " + fy + '\n');
							}
							break;
						}
					}
				}
				if(isGoal) {
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
