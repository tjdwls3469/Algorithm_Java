import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1149_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] RGB = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[N][N];
		memo[0][0] = RGB[0][0];
		memo[0][1] = RGB[0][1];
		memo[0][2] = RGB[0][2];
		for (int i = 1; i < N; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + RGB[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + RGB[i][1];
			memo[i][2] = Math.min(memo[i-1][1], memo[i-1][0]) + RGB[i][2];
		}
		
		System.out.println(Math.min(Math.min(memo[N-1][0], memo[N-1][1]), memo[N-1][2]));
	}
}
