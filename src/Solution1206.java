import java.util.Scanner;

public class Solution1206 {
	public static final int TC = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt;
		int ans;
		for(int i=1;i<=TC;i++) {
			cnt = sc.nextInt();
			ans = 0;
			int[] building = new int[cnt];
			for(int j=0;j<cnt;j++) {
				building[j] = sc.nextInt();
			}
			for(int j=2;j<=cnt-3;j++) {
				int max = building[j-2];
				for(int k=j-2;k<=j+2;k++) {
					if(j == k) {
						continue;
					}
					if(building[k] > max) {
						max = building[k];
					}
				}
				if(max < building[j]) {
					ans += building[j] - max;
				}
			}
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	}
}
