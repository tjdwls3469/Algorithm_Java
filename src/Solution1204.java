import java.util.Scanner;

public class Solution1204 {
	public static final int STUDENT = 1000;
	public static final int POINT = 101;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt;
		int num;
		cnt = sc.nextInt();
		for(int i=0;i<cnt;i++) {
			int[] count = new int[POINT];
			int grade;
			int index = 0;
			int ans = 0;
			num = sc.nextInt();
			for(int j=0;j<STUDENT;j++) {
				grade = sc.nextInt();
				count[grade]++;
			}
			for(int j=0;j<POINT;j++) {
				if(count[j] >= ans) {
					ans = count[j];
					index = j;
				}
			}
			System.out.println("#" + num + " " + index);
		}
	}
}
