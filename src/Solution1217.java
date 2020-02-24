import java.util.Scanner;

public class Solution1217 {
	public static final int TC = 10;
	
	public static int solve(int num, int cnt, int index, int ans) {
		if(index > cnt) {
			return ans;
		}
		ans *= num;
		return solve(num, cnt, index+1, ans);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=TC;i++) {
			sc.nextInt();
			int num = sc.nextInt();
			int cnt = sc.nextInt();
			int ans;
			ans = solve(num, cnt, 1, 1);
			System.out.println("#" + i + ' ' + ans);
		}
	}
}
