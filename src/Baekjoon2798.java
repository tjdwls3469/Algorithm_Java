import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int cnt = Integer.parseInt(st.nextToken());
		int maxVal = Integer.parseInt(st.nextToken());
		int[] num = new int[cnt];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		int index = 0;
		while (st.hasMoreElements()) {
			num[index++] = Integer.parseInt(st.nextToken());
		}
		
		int ans = -1;
		for (int i = 0; i < cnt; i++) {
			int sum = num[i];
			for (int j = 0; j < cnt; j++) {
				if(j == i) {
					continue;
				}
				sum += num[j];
				for (int k = 0; k < cnt; k++) {
					if(k == i || k == j) {
						continue;
					}
					sum += num[k];
					if(sum <= maxVal && sum > ans) {
						ans = sum;
					}
					sum -= num[k];
				}
				sum -= num[j];
			}
		}
		System.out.println(ans);
	}
}
