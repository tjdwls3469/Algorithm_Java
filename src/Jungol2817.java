import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol2817 {
	public static int[] nums = new int[13];
	public static int[] lotto = new int[6];
	public static int cnt;
	public static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		cnt = Integer.parseInt(st.nextToken());
		int index = 0;
		while(st.hasMoreTokens()) {
			nums[index++] = Integer.parseInt(st.nextToken());	
		}
		combination(0, 0);
		System.out.println(ans);
	}
	
	public static void combination(int sel, int start) {
		if(sel == 6) {
			for (int i = 0; i < lotto.length; i++) {
				ans.append(lotto[i] + " ");
			}
			ans.append('\n');
			return;
		}
		
		for (int i = start; i < cnt; i++) {
			lotto[sel] = nums[i];
			combination(sel+1, i+1);
		}
	}
}
