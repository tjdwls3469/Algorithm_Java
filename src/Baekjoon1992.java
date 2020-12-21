import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1992 {
	public static char[][] map;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}	// map 초기화 OK
		
		solve(0, 0, N);
		System.out.println(sb);
	}

	public static char val;
	public static boolean check;
	
	private static void solve(int x, int y, int size) {
		val = map[x][y];
		check = true;
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(val != map[i][j]) {
					check = false;
					break;
				}
			}
		}
		
		if(check) {
			sb.append(val);
			return;
		}
		
		int half = size / 2;
		sb.append('(');
		solve(x, y, half);
		solve(x, y + half, half);
		solve(x + half, y, half);
		solve(x + half, y + half, half);
		sb.append(')');
	}
}
