import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] map = new String[N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}

		int[] cntAry = new int['Z' + 1];
		char ch;
		char maxCh = '\0';
		int max = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();
		int ans = 0;

		for (int i = 0; i < M; i++) {
			Arrays.fill(cntAry, 0);
			max = Integer.MIN_VALUE;

			for (int j = 0; j < N; j++) {
				ch = map[j].charAt(i);
				cntAry[ch]++;

				if (cntAry[ch] == max && ch < maxCh) {
					maxCh = ch;
				} else if (cntAry[ch] > max) {
					max = cntAry[ch];
					maxCh = ch;
				}
			}

			sb.append(maxCh);
			ans += (N - max);
		}

		sb.append('\n').append(ans);
		System.out.println(sb);
	}
}
