import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2752 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] ary = new int[3];
		for (int i = 0; i < 3; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(ary[i]).append(' ');
		}
		System.out.println(sb);
	}
}
