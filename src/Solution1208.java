import java.util.Scanner;
import java.util.Arrays;

public class Solution1208 {
	public static final int TEST_CNT = 10;
	public static final int BOX_CNT = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] box = new int[BOX_CNT];
		int dump;
		for(int i=1;i<=TEST_CNT;i++) {
			dump = sc.nextInt();
			for(int j=0;j<BOX_CNT;j++) {
				box[j] = sc.nextInt();
			}
			Arrays.sort(box);
			for(int j=0;j<dump;j++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
			System.out.println("#" + i + " " + (box[99] - box[0]));
		}
	}
}
