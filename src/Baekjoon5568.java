import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5568 {
	private static int n, k;
	private static int[] ary;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		nums = new int[k];
		ary = new int[n];
		isSelected = new boolean[n];
		for (int i = 0; i < n; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		permutation(0);
		System.out.println(ans);
	}
	
	public static int[] nums;
	private static boolean[] isSelected;
	private static boolean[] check = new boolean[100000000];
	public static StringBuilder sb = new StringBuilder();
	public static int ans;

	private static void permutation(int cnt) {
		if(cnt == k) {
			sb.setLength(0);
			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]);
			}
			
			int num = Integer.parseInt(sb.toString());
			if(!check[num]) {
				check[num] = true;
				ans++;
			}
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			nums[cnt] = ary[i];
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
