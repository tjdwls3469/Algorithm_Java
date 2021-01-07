import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][3];
		int[][] memo = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + map[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + map[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + map[i][2];
		}
		
		System.out.println(Math.min(Math.min(memo[N][0], memo[N][1]), memo[N][2]));
	}
}
