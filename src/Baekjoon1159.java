import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1159 {
	public static int[] check = new int[26];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			check[br.readLine().charAt(0) - 'a']++;
		}
		boolean isExist = false;
		for (int i = 0; i < check.length; i++) {
			if(check[i] >= 5) {
				isExist = true;
				System.out.print((char)(i+'a'));
			}
		}
		if(!isExist) {
			System.out.println("PREDAJA");
		}
	}
}
