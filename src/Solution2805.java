import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//            0,3
//        1,2 1,3 1,4
//    2,1 2,2 2,3 2,4 2,5
//3,0 3,1 3,2 3,3 3,4 3,5 3,6
//    4,1 4,2 4,3 4,4 4,5
//        5,2 5,3 5,4
//            6,3

public class Solution2805 {
	public static String[] map = new String[49];
	public static StringBuffer ans = new StringBuffer();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int row = Integer.parseInt(br.readLine());
			for (int i = 0; i < row; i++) {
				map[i] = br.readLine();
			}
			
			int max = row/2;
			int sum = 0;
			for (int i = 0; i <= max; i++) {
				for (int j = max - i; j <= max + i; j++) {
					sum += map[i].charAt(j) - '0';
				}
			}
			
			for (int i = max + 1; i < row; i++) {
				for (int j = i - max; j <= max + row - i - 1; j++) {
					sum += map[i].charAt(j) - '0';
				}
			}
			ans.append("#" + tc + " " + sum + '\n');
		}
		System.out.println(ans);
	}
}
