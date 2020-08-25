import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2447 {
	public static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		solve(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	private static void solve(int x, int y, int size) {
		if(size == 1) {
			map[x][y] = '*';
			return;
		}
		
		int div = size / 3;
		solve(x, y, div);
		solve(x, y + div, div);
		solve(x, y + div + div, div);
		
		solve(x + div, y, div);
		solve(x + div, y + div + div, div);
		
		solve(x + div + div, y, div);
		solve(x + div + div, y + div, div);
		solve(x + div + div, y + div + div, div);
	}
}
