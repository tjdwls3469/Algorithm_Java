import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 더하거나 빼는 동작을 99개의 숫자에 적용해보면 2^99의 시간이 걸려서 시간초과
 * 따라서 재귀함수에 메모이제이션 적용하는 생각을 해봄
 */

public class Baekjoon5557 {
	public static int[] nums = new int[101];
	public static int numCnt;
	public static int goal;		// 제일 마지막 숫자 (x+y-.... = z) z에 해당하는 숫자 
	public static long[][] memo = new long[101][21];		// [인덱스][합] = 만들수 있는 등식의 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numCnt = Integer.parseInt(br.readLine()) - 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numCnt; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		goal = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 21; j++) {
				memo[i][j] = -1;
			}
		}
		System.out.println(solve(1, nums[0]));
	}
	
	public static long solve(int cnt, int sum) {
		if(memo[cnt][sum] != -1) {		// 메모이제션을 통해 중복 호출 방지
			return memo[cnt][sum];
		}
		if(cnt == numCnt) {		// 인덱스가 마지막 숫자 전이라면 (x+....-y = z) y에 해당하는 개수
			return sum == goal ? 1 : 0;		// 계산한 값이 z라면 1 아니면 0 리턴
		}
		
		memo[cnt][sum] = 0;
		if(sum + nums[cnt] <= 20) {
			memo[cnt][sum] += solve(cnt + 1, sum + nums[cnt]);
		}
		if(sum - nums[cnt] >= 0) {
			memo[cnt][sum] += solve(cnt + 1, sum - nums[cnt]);
		}
		return memo[cnt][sum];
	}
}
