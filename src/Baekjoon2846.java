import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2846 {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] ary = new int[cnt];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int index = 0;
		while(st.hasMoreTokens()) {
			ary[index++] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int sum = 0;
		for (int i = 1; i < cnt; i++) {
			if(ary[i] > ary[i-1]) {
				sum += ary[i] - ary[i-1];
				continue;
			}
			if(sum > ans) {
				ans = sum;
			}
			sum = 0;
		}
		if(sum > ans) {
			ans = sum;
		}
		System.out.println(ans);
	}
}
