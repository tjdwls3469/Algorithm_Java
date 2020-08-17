import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14889 {
	public static int N;
	public static boolean[] check;
	public static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int size = N + 1;	// 0번 자리 안씀
		check = new boolean[size];
		map = new int[size][size];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // map 초기화 OK

		combination(0, 1);
		System.out.println(ans);
	}
	
	public static int start;
	public static int link;
	public static int ans = Integer.MAX_VALUE;
	public static int diff;
	
	public static void combination(int cnt, int num) {
		if (cnt == N / 2) {
			start = link = 0;
			for (int i = 1; i < check.length; i++) {
				for (int j = 1; j < check.length; j++) {
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

		if (cnt == 0) {		// 가지치기(이게 없으면 중복 발생) 예) 스타트(1,3,6) 링크(2,4,5) / 스타트(2,4,5) 링크(1,3,6) 중복발생
			check[1] = true;
			combination(cnt + 1, 2);
			return;
		}
		for (int i = num; i <= N; i++) {
			check[i] = true;
			combination(cnt + 1, i + 1);
			check[i] = false;
		}
	}
}
