import java.util.Scanner;

public class Solution1216 {
	public static final int TC = 10;
	public static final int SIZE = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=TC;i++) {
			int ans = 0;
			sc.nextInt();
			sc.nextLine();
			String[] plate = new String[SIZE];
			for(int j=0;j<SIZE;j++) {
				plate[j] = sc.nextLine();
			}
			int max = 0;
			for(int j=0;j<SIZE;j++) {
				int len = 100;
				int temp = 0;
				boolean check = false;
				while(true) {
					if(len == 0) {
						break;
					}
					for(int k=0;k<SIZE+1-len;k++) {
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
							temp = len;
							check = true;
							break;
						}
					}
					if(check == true) {
						if(len > max) {
							max= len;
						}
						break;
					}
					len--;
				}
			}
			for(int j=0;j<SIZE;j++) {
				int len = 100;
				int temp = 0;
				boolean check = false;
				while(true) {
					if(len == 0) {
						break;
					}
					for(int k=0;k<SIZE+1-len;k++) {
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
							temp = len;
							check = true;
							break;
						}
					}
					if(check == true) {
						if(len > max) {
							max= len;
						}
						break;
					}
					len--;
				}
			}
			System.out.println("#" + i + " " + max);
		}
	}
}
