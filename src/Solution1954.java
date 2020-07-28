import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int rc = Integer.parseInt(br.readLine());
			int[][] map = new int[rc][rc];
			
			int cnt = 1;
			for (int j = 0; j < rc/2+1; j++) {
				for (int i = j; i < rc-1-j; i++) {
					map[j][i] = cnt++;
				}
				for (int i = j; i < rc-1-j; i++) {
					map[i][rc-1-j] = cnt++;
				}
				for (int i = rc-1-j; i >= 1+j; i--) {
					map[rc-1-j][i] = cnt++;
				}
				for (int i = rc-1-j; i >= 1+j; i--) {
					map[i][j] = cnt++;
				}
			}
			if(rc%2 != 0) {
				map[rc/2][rc/2] = cnt;
			}

			ans.append("#" + tc + '\n');
			for (int i = 0; i < rc; i++) {
				for (int j = 0; j < rc; j++) {
					ans.append(map[i][j] + " ");
				}
				ans.append('\n');
			}
		}
		System.out.println(ans);
	}
}
