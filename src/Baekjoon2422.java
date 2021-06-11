import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2422 {
	private static int N, M;
	private static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		int x, y;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = true;
		}
		
		combination(0, 1);
		System.out.println(ans);
	}
	
	public static int[] nums = new int[3];
	public static int ans;

	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			ans++;
			return;
		}
		
		for (int i = start; i <= N; i++) {
			
			boolean isGood = true;
			for (int j = 0; j < cnt; j++) {
				if(map[i][nums[j]]) {
					isGood = false;
					break;
				}
			}
			
			if(!isGood) {
				continue;
			}
			
			nums[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
