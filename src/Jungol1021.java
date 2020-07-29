import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1021 {
	public static int[][] info = new int[101][101];
	public static boolean[] check = new boolean[101];
	public static int[] ans = new int[101];
	public static int goal;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		goal = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			check[row] = true;	// num은 완제품 or 중간부품
			int col = Integer.parseInt(st.nextToken());
			int needCnt = Integer.parseInt(st.nextToken());
			info[row][col] = needCnt;	// row를 만드는데 col이 needCnt개 필요
		}
		
//		solve(goal);
		search2(goal);
		for (int i = 0; i < ans.length; i++) {
			if(ans[i] != 0) {
				sb.append(i + " " + ans[i] + '\n');
			} 
		}
		
		System.out.println(sb);
	}
	
	public static void solve(int num) {
		if(!check[num]) {	// num이 기본 부품이라면
			ans[num]++;
			return;
		}
		
		for (int i = 1; i < goal; i++) {	//info[num][i]에는 num을 만들기 위해 필요한 i의 개수가 들어있음
			if(info[num][i] != 0) {		// num을 만들기 위해 필요한 부품(i)이 있다면
				for (int j = 0; j < info[num][i]; j++) {	// 필요한 부품(i)의 개수만큼 호출
					solve(i);
				}
			}
		}
	}
	
	// 교수님 재귀함수 && 메모이제이션X
	// 제품을 만들기 위해 필요한 기본 부품의 배열을 리턴하는 메서드
	// 0번 index => 0: 계산 안한상태, -1: 계산함(중간부품), -2:계산함(기본부품)
	public static int[] search(int n) {
		int[] result = new int[info.length + 1];	// n번째 제품을 만들기 위해 피료한 기본 부품의 배열
		result[0] = -2;		// 계산함 표시 (기본부품)
		for (int i = 1; i < info.length; i++) {
			if(info[n][i] != 0) {	// 사용한 부품이 있다면, 기본부품은 아님
				int[] val = search(i);		// 재귀함수 호출
				if(val[0] == -2) {
					result[i] += info[n][i];
				}else {		// 중간부품이면
					for (int j = 0; j < val.length; j++) {
						result[j] += info[n][i] * val[j];
					}
				}
				result[0] = -1;		// 계산함 표시(중간부품)
			}
		}
		return result;
	}
	
	public static int[][] result;	
	// 제품을 만들기 위해 필요한 기본 부품을 계산한 결과를 저장
	
	// 교수님 재귀함수 && 메모이제이션 O
	// 0번 index => 0: 계산 안한상태, -1: 계산함(중간부품), -2:계산함(기본부품)
	public static void search2(int n) {
		if(result[n][0] < 0) {		// 계산을 이미 했다면
			return;
		}
		
		result[n][0] = -2;		// 계산함 표시 (기본부품)
		for (int i = 1; i < info.length; i++) {
			if(info[n][i] != 0) {	// 사용한 부품이 있다면, 기본부품은 아님
				search(i);		// 재귀함수 호출, 하위 부품을 탐색 result[i] 행에는 값이 완성되어있음
				if(result[i][0] == -2) {	// 기본부품이면
					result[n][i] += info[n][i];
				}else {		// 중간부품이면
					for (int j = 0; j < info.length; j++) {
						result[n][j] += info[n][i] * result[i][j];
					}
				}
				result[n][0] = -1;		// 계산함 표시(중간부품)
			}
		}
		return;
	}
}
