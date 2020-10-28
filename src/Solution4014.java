import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {
	public static int[][] map = new int[20][20];
	public static boolean[][] check = new boolean[20][20];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N, X, num, ans = 0;
		boolean ok;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = false;
				}
			}
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				num = map[i][0];
				ok = true;
				
				for (int j = 1; j < N; j++) {
					if (map[i][j] == num) {
						continue;
					}
					
					if (map[i][j] == num - 1) {
						if (j + X - 1 >= N) {
							ok = false;
							break;
						}
						for (int k = j; k <= j + X - 1; k++) {
							if (map[i][k] != num - 1 || check[i][k]) {
								ok = false;
								break;
							}
						}
						if (ok == false) {
							break;
						}
						num = map[i][j];
						for (int k = j; k <= j + X - 1; k++) {
							check[i][k] = true;
						}
					}
					else if (map[i][j] == num + 1) {
						if (j - X < 0) {
							ok = false;
							break;
						}
						for (int k = j - 1; k >= j - X; k--) {
							if (map[i][k] != num || check[i][k] == true) {
								ok = false;
								break;
							}
						}
						if (ok == false) {
							break;
						}
						num = map[i][j];
						for (int k = j - 1; k >= j - X; k--) {
							check[i][k] = true;
						}
					}
					else {
						ok = false;
						break;
					}
				}
				if (ok == true) {
					ans++;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check[i][j] = false;
				}
			}
			
			for (int i = 0; i < N; i++) {
				num = map[0][i];
				ok = true;
				for (int j = 1; j < N; j++) {
					if (map[j][i] == num) {
						continue;
					}
					if (map[j][i] == num - 1) {
						if (j + X - 1 >= N) {
							ok = false;
							break;
						}
						for (int k = j; k <= j + X - 1; k++) {
							if (map[k][i] != num - 1 || check[k][i] == true) {
								ok = false;
								break;
							}
						}
						if (ok == false) {
							break;
						}
						num = map[j][i];
						for (int k = j; k <= j + X - 1; k++) {
							check[k][i] = true;
						}
					}
					else if (map[j][i] == num + 1) {
						if (j - X < 0) {
							ok = false;
							break;
						}
						for (int k = j - 1; k >= j - X; k--) {
							if (map[k][i] != num || check[k][i] == true) {
								ok = false;
								break;
							}
						}
						if (ok == false) {
							break;
						}
						num = map[j][i];
						for (int k = j - 1; k >= j - X; k--) {
							check[k][i] = true;
						}
					}
					else {
						ok = false;
						break;
					}
				}
				if (ok == true) {
					ans++;
				}
			} // end of for
			sb.append(ans).append('\n');
		} // end of TC
		System.out.print(sb);
	}
}
