import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4008 {
	public static int[] oper = new int[11];
	public static int[] ans = new int[11];
	public static boolean[] isSelected = new boolean[11];
	public static int[] num = new int[12];
	public static int N;
	public static int max, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int cnt, index;
		
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 11; i++) {
				isSelected[i] = false;
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			index = 0;
			
			for (int i = 1; i <= 4; i++) {
				cnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < cnt; j++) {
					oper[index++] = i;
				}
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			sb.append('#').append(tc).append(' ').append(max-min).append('\n');
		} // end of tc
		System.err.print(sb);
	}

	public static void permutation(int cnt) {
		if(cnt == N-1) {
			int result = num[0];
			
			for (int i = 0; i < cnt; i++) {
				switch (ans[i]) {
				case 1:
					result += num[i+1];
					break;
				case 2:
					result -= num[i+1];
					break;
				case 3:
					result *= num[i+1];
					break;
				case 4:
					result /= num[i+1];
					break;
				}
			}
			
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
			return;
		}
		
		for (int i = 0; i < N-1; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			ans[cnt] = oper[i];
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
