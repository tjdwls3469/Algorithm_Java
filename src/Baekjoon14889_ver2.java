import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14889_ver2 {
	private static int N;
	private static int goal;
	private static int[][] map;
	private static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		goal = N / 2;
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 1);
		System.out.println(ans);
	}
	
	public static int startTeam;
	public static int linkTeam;
	public static int ans = Integer.MAX_VALUE;

	private static void combination(int cnt, int start) {
		if(cnt == goal) {
//			print();
			startTeam = linkTeam = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j) {
						continue;
					}
					if(check[i] && check[j]) {
						startTeam += map[i][j];
					}else if(!check[i] && !check[j]) {
						linkTeam += map[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(startTeam - linkTeam));
			
			return;
		}

		for (int i = start; i <= N; i++) {
			check[i] = true;
			combination(cnt + 1, i + 1);
			check[i] = false;
		}
	}
	
	public static void print() {
		for (int i = 1; i < check.length; i++) {
			if(check[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
