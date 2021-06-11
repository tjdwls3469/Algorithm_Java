import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon {
	private static int N, size, cnt;
	private static String[] map;
	private static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new String[N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i].charAt(j) == '1' && !check[i][j]) {
					size++;
					cnt = 0;
					
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(size).append('\n');
		
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.print(sb);
	}

	public static int[] dx = { 0, -1, 0, 1 };
	public static int[] dy = { -1, 0, 1, 0 };
	public static int nx, ny;

	private static void dfs(int x, int y) {
		cnt++;
		check[x][y] = true;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx].charAt(ny) == '1' && !check[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}
