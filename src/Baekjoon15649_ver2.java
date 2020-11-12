import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15649_ver2 {
	public static int N, M;
	public static boolean[] isSelected;
	public static int[] ary;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		N = line.charAt(0) - '0';
		M = line.charAt(2) - '0';
		
		isSelected = new boolean[N+1];
		ary = new int[M];
		
		permutation(0);
		
		System.out.print(sb);
	}

	public static void permutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ary[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			ary[cnt] = i;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
