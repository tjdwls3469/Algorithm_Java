import java.util.Scanner;

public class Baekjoon2941 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String word = new Scanner(System.in).nextLine();
		int start = word.length() - 1;
		int ans = 0;
		char ch;
		char preCh;
		char prePreCh;
		
		for (int i = start; i >= 0; i--) {
			ch = word.charAt(i);
			switch (ch) {
			case '-':
				ans++;
				i--;
				break;
			case 'j':
				if(i == 0) {
					ans++;
					break;
				}
				preCh = word.charAt(i-1);
				if(preCh == 'l' || preCh == 'n') {
					ans++;
					i--;
					break;
				}
				ans++;
				break;
			case '=':
				if(i == 0) {
					ans++;
					break;
				}
				preCh = word.charAt(i-1);
				if(preCh == 's' || preCh == 'c') {
					ans++;
					i--;
					break;
				}
				if(i < 2) {
					if(preCh == 'z') {
						ans++;
						i--;
						break;
					}
					ans++;
					break;
				}
				prePreCh = word.charAt(i-2);
				if(prePreCh == 'd' && preCh == 'z') {
					ans++;
					i-=2;
					break;
				}
				if(prePreCh != 'd' && preCh == 'z') {
					ans++;
					i--;
					break;
				}
				ans++;
				break;
			default:
				ans++;
				break;
			}
		}
		System.out.println(ans);
	}
}
