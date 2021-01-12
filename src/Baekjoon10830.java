import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10830 {
	public static int N;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map = solve(map, B);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}

	public static int[][] solve(int[][] A, long B) {
		if(B == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					A[i][j] %= 1000;
				}
			}
			
			return A;
		}
		
		int[][] result = solve(A, B/2);
		
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					temp[i][j] += result[i][k] * result[k][j];
					temp[i][j] %= 1000;
				}
			}
		}
		result = temp;
		
		if(B % 2 != 0) {
			int[][] temp2 = new int[N][N];
					
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						temp2[i][j] += temp[i][k] * map[k][j];
						temp2[i][j] %= 1000;
					}
				}
			}
			
			result = temp2;
		}
		
		return result;
	}
}
