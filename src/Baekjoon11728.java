import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] ary = new int[N+M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = N; i < N+M; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ary);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ary.length; i++) {
			sb.append(ary[i]).append(' ');
		}
		System.out.println(sb);
	}
}
