import java.util.Scanner;

public class Solution1215 {
	public static final int TC = 10;
	public static final int SIZE = 8;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=TC;i++) {
			int ans = 0;
			int len = sc.nextInt();
			sc.nextLine();
			String[] plate = new String[SIZE];
			for(int j=0;j<SIZE;j++) {
				plate[j] = sc.nextLine();
			}
			for(int j=0;j<SIZE;j++) {
				for(int k=0;k<9-len;k++) {
					boolean ok = true;
					int n = 0;
					for(int m=k;m<=(len-1+k+k)/2;m++) {
						if(plate[j].charAt(m) != plate[j].charAt(len-1+k-n)) {
							ok = false;
							break;
						}
						n++;
					}
					if(ok == true) {
						ans++;
					}
				}
			}
			for(int j=0;j<SIZE;j++) {
				for(int k=0;k<9-len;k++) {
					boolean ok = true;
					int n = 0;
					for(int m=k;m<=(len-1+k+k)/2;m++) {
						if(plate[m].charAt(j) != plate[len-1+k-n].charAt(j)) {
							ok = false;
							break;
						}
						n++;
					}
					if(ok == true) {
						ans++;
					}
				}
			}
			System.out.println("#" + i + " " + ans);
		}
	}
}
