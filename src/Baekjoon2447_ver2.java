import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2447_ver2 {
	public static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		solve(0, 0, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '*') {
					sb.append('*');
					continue;
				}
				
				sb.append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void solve(int x, int y, int n) {
		if(n == 1) {
			map[x][y] = '*';
			return;
		}
		
		for (int i = x; i < (x+n); i+=(n/3)) {
			for (int j = y; j < (y+n); j+=(n/3)) {
				if(i == x+(n/3) && j == y+(n/3)) {
					continue;
				}
				
				solve(i, j, n/3);
			}
		}
	}
}
