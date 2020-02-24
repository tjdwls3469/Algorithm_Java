import java.util.Scanner;
import java.util.ArrayList;

public class Solution1218 {
	public static final int TC = 10;
	public static ArrayList<Character> bracket = new ArrayList<Character>();
	public static int top = -1;
	
	public static void push(char c, int strLen) {
		if(top == strLen) {
			return;
		}
		bracket.add(c);
		top++;
	}
	
	public static char pop() {
		if(top == -1) {
			return 'e';
		}
		top--;
		return bracket.remove(bracket.size()-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = 0;
		String str;
		for(int i=1;i<=TC;i++) {
			len = sc.nextInt();
			sc.nextLine();
			str = sc.nextLine();
			int strLen = str.length();
			char temp;
			boolean ok = true;
			for(int j=0;j<strLen;j++) {
				temp = str.charAt(j);
				if(temp == '(' || temp == '[' || temp == '{' || temp == '<') {
					push(temp, strLen);
				}else {
					char c = pop();
					if(c == 'e') {
						ok = false;
						break;
					}
					switch(c) {
					case '(' :
						if(str.charAt(j) != ')') {
							ok = false;
						}
						break;
					case '[' :
						if(str.charAt(j) != ']') {
							ok = false;
						}
						break;
					case '{' :
						if(str.charAt(j) != '}') {
							ok = false;
						}
						break;
					case '<' : 
						if(str.charAt(j) != '>') {
							ok = false;
						}
						break;
					default:;
						break;
					}
					if(ok == false) {
						break;
					}
				}
			}
			if(ok == true) {
				System.out.println("#" + i + ' ' + "1");
			}else {
				System.out.println("#" + i + ' ' + "0");
			}
		}
	}
}
