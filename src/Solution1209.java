import java.util.Scanner;

public class Solution1209 {
	public static final int TC = 10;
	public static final int SIZE = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] num = new int[SIZE][SIZE];
		int max;
		int sum;
		for(int i=1;i<=TC;i++) {
			sc.nextInt();
			max = 0;
			for(int j=0;j<SIZE;j++) {
				sum = 0;
				for(int k=0;k<SIZE;k++) {
					num[j][k] = sc.nextInt();
					sum += num[j][k];
				}
				if(sum > max) {
					max = sum;
				}
			}
			for(int j=0;j<SIZE;j++) {
				sum = 0;
				for(int k=0;k<SIZE;k++) {
					sum += num[k][j];
				}
				if(sum > max) {
					max = sum;
				}
			}
			sum = 0;
			for(int j=0;j<SIZE;j++) {
				sum += num[j][j];
				if(sum > max) {
					max = sum;
				}
			}
			sum = 0;
			for(int j=0;j<SIZE;j++) {
				sum += num[j][99-j];
				if(sum > max) {
					max = sum;
				}
			}
			System.out.println("#" + i + " " + max);
		}
	}
}