import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 테스트 케이스만큼 for문을 돌린다
 * 2. 덤프 횟수를 입력받는다
 * 3. 배열에 상자의 높이를 넣는다
 * 4. 덤프 횟수만큼 for문을 돌면서 (최대값 -1) (최소값+1) (정렬) 작업을 반복한다
 * 5. 결과는 StringBuilder에 모은 후 한번에 출력한다
 */

public class Solution1208 {
	public static final int ROW = 100;
	public static final int TEST_CASE = 4;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] boxHeight = new int[ROW];
		StringBuilder ans = new StringBuilder();
		
		for (int i = 1; i <= TEST_CASE; i++) {
			int dumpCnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			while(st.hasMoreTokens()) {
				boxHeight[index++] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(boxHeight);
			for (int j = 0; j < dumpCnt; j++) {
				boxHeight[0]++;
				boxHeight[99]--;
				Arrays.sort(boxHeight);
			}
			ans.append("#" + i + " " + (boxHeight[99] - boxHeight[0]) + '\n');
		}
		System.out.println(ans);
	}
}
