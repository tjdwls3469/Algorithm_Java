import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15661 {
	public static int N;
	public static int[][] map;
	public static boolean[] check;
	public static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// map 초기화 OK
		
		int half = N / 2;
		for (int player = 2; player <= half; player++) {
			combination(0, 0, player);
		}
		
		System.out.println(ans);
	}
	
	public static int start;
	public static int link;
	public static int diff;

	private static void combination(int cnt, int start, int player) {
		if(cnt == player) {
			start = link = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) {
						continue;
					}
					if(check[i] && check[j]) {		// check가 true이면 스타트팀
						start += map[i][j];
						continue;
					}
					if(!check[i] && !check[j]) {	// check가 false이면 링크팀
						link += map[i][j];
					}
				}
			}
			diff = Math.abs(start-link);
			if(diff < ans) {
				ans = diff;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			check[i] = true;
			combination(cnt + 1, i + 1, player);
			check[i] = false;
		}
	}
}
