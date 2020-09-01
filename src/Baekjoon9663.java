import java.util.Scanner;

public class Baekjoon9663 {
	public static boolean[][] map;
	public static int ans;
	public static int N;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		N = new Scanner(System.in).nextInt();
		map = new boolean[N][N];

		solve(0);
		System.out.println(ans);
	}

	private static void solve(int row) {
		if (row == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (check(row, i)) {
				map[row][i] = true;
				solve(row + 1);
				map[row][i] = false;
			}
		}
	}

	private static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (map[i][col]) { // 0부터 row전까지 같은 열에 퀸이 있으면 false 리턴
				return false;
			}
		}
		int lx, ly, rx, ry;
		lx = rx = row;
		ly = ry = col;
		
		// 왼쪽 대각선
		while(true) {
			lx--;
			ly--;
			if(lx < 0 || ly < 0) {
				break;
			}
			if(map[lx][ly]) {
				return false;
			}
		}
		
		// 오른쪽 대각선
		while(true) {
			rx--;
			ry++;
			if(rx < 0 || ry >= N) {
				break;
			}
			if(map[rx][ry]) {
				return false;
			}
		}
		return true;
	}
}
