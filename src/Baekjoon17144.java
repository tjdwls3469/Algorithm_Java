import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		int upAir = 0;
		int downAir = 0;
		
		int[][] map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(upAir == 0) {
						upAir = i;
					}else {
						downAir = i;
					}
				}
			}
		}
		
		int dx[] = {0, -1, 0, 1};
		int dy[] = {-1, 0, 1, 0};
		int nx = 0;
		int ny = 0;
		int cnt = 0;
		int[][] temp = new int[row][col];
		
		for (int m = 0; m < time; m++) {
			// 미세먼지 확산
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(map[i][j] > 0) {
						cnt = 0;
						for (int k = 0; k < dx.length; k++) {
							nx = i + dx[k];
							ny = j + dy[k];
							if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] != -1) {
								temp[nx][ny] += map[i][j]/5;
								cnt++;
							}
						}
						map[i][j] -= (map[i][j]/5) * cnt;
						if(map[i][j] < 0) {
							map[i][j]= 0;
						}
					}
				}
			} // end of 미세먼지 확산
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					map[i][j] += temp[i][j];
					temp[i][j] = 0;
				}
			}
			
			// 위 공기청정기 작동
			if(map[upAir-1][0] != 0) {
				map[upAir-1][0] = 0;
			}
			for (int i = upAir-2; i >= 0; i--) {
				map[i+1][0] = map[i][0];
			}
			for (int i = 1; i < col; i++) {
				map[0][i-1] = map[0][i];
			}
			for (int i = 1; i <= upAir; i++) {
				map[i-1][col-1] = map[i][col-1];
			}
			for (int i = col-2; i >= 1; i--) {
				map[upAir][i+1] = map[upAir][i];
			}
			map[upAir][1] = 0;
			
			// 아래 공기청정기 작동
			if(map[downAir+1][0] != 0) {
				map[downAir+1][0] = 0;
			}
			for (int i = downAir+2; i < row; i++) {
				map[i-1][0] = map[i][0];
			}
			for (int i = 1; i < col; i++) {
				map[row-1][i-1] = map[row-1][i];
			}
			for (int i = row-2; i >= downAir; i--) {
				map[i+1][col-1] = map[i][col-1];
			}
			for (int i = col-2; i >= 1; i--) {
				map[downAir][i+1] = map[downAir][i];
			}
			map[downAir][1] = 0;
		}
		
		int sum = 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}	// end of main
}	// end of class