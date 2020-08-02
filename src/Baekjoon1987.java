import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1987 {
	public static int row;
	public static int col;
	public static String[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new String[row];
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine();
		}
		check[map[0].charAt(0) - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	public static boolean[] check = new boolean[26];
	public static int ans = 1;
	
	public static void dfs(int x, int y, int  cnt) {
		if(cnt > ans) {
			ans = cnt;
		}
		
		int nx = 0;
		int ny = 0;
		for (int i = 0; i < dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= 0 && nx < row && ny >= 0 && ny < col && !check[map[nx].charAt(ny) - 'A']) {
				check[map[nx].charAt(ny) - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				check[map[nx].charAt(ny) - 'A'] = false;
			}
		}
	}
}
