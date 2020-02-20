import java.util.Scanner;

public class Solution1213 {
	public static final int TC = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=TC;i++) {
			String sentence;
			String word;
			int ans = 0;
			int temp = Integer.parseInt(sc.nextLine());
			word = sc.nextLine();
			sentence = sc.nextLine();
			int len = word.length();
			int jump = 1;
//			System.out.println(temp + " " + word + " " + sentence);
//			System.out.println(temp + " " + len + " " + sentence.length());
			for(int j=len-1;j<sentence.length();j+=jump) {
//				System.out.print(j + " ");
				boolean ok = true;
				boolean check = false;
				if(sentence.charAt(j) == word.charAt(len-1)) {
					int l=2;
					for(int k=j-1;k>=j-len+1;k--,l+=1) {
//						System.out.println(sentence.charAt(k) + " " + word.charAt(len-l));
						if(sentence.charAt(k) != word.charAt(len-l)) {
							ok = false;
							break;
						}
					}
					if(ok == true) {
						ans++;
					}
					jump = len;
				}else {
					for(int k=len-2;k>=0;k--) {
						if(word.charAt(k) == sentence.charAt(j)) {
							check = true;
							jump = len-k-1;
							break;
						}
					}
					if(check == false) {
						jump = len;
					}
				}
			}
			System.out.println("#" + i + " " + ans);
		}
	}
}
