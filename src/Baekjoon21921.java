import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] ary = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = X - 1;
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum += ary[i];
		}

		int max = sum;
		int maxCnt = 1;
		while (true) {
			sum -= ary[left];
			left++;
			
			right++;
			if (right >= N) {
				break;
			}
			sum += ary[right];
			
			if(sum > max) {
				max = sum;
				maxCnt = 1;
				continue;
			}
			
			if(sum == max) {
				maxCnt++;
				continue;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(max == 0) {
			sb.append("SAD");
			System.out.println(sb);
			return;
		}
		
		sb.append(max).append('\n').append(maxCnt);
		System.out.println(sb);
	}
}
