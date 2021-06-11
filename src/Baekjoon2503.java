import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2503 {
	public static int[] aAry;
	public static int[] bAry;
	public static int[] cAry;
	public static int[] strikeAry;
	public static int[] ballAry;
	private static int N, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		aAry = new int[N];
		bAry = new int[N];
		cAry = new int[N];
		strikeAry = new int[N];
		ballAry = new int[N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			aAry[i] = num / 100;
			num %= 100;
			bAry[i] = num / 10;
			num %= 10;
			cAry[i] = num;
			strikeAry[i] = Integer.parseInt(st.nextToken());
			ballAry[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		System.out.println(ans);
	}
	
	public static boolean[] isSelected = new boolean[10];
	public static int[] nums = new int[3];

	private static void permutation(int cnt) {
		if(cnt == 3) {
			int s = 0;
			int b = 0;
			int sameCnt = 0;
			
			for (int i = 0; i < N; i++) {
				s = b = 0;
				
				if(nums[0] == aAry[i]) {
					s++;
				}else if(nums[0] == bAry[i]) {
					b++;
				}else if(nums[0] == cAry[i]) {
					b++;
				}
				
				if(nums[1] == bAry[i]) {
					s++;
				}else if(nums[1] == aAry[i]) {
					b++;
				}else if(nums[1] == cAry[i]) {
					b++;
				}
				
				if(nums[2] == cAry[i]) {
					s++;
				}else if(nums[2] == aAry[i]) {
					b++;
				}else if(nums[2] == bAry[i]) {
					b++;
				}
				
				if(s == strikeAry[i] && b == ballAry[i]) {
					sameCnt++;
				}
			}

			if(sameCnt == N) {
				ans++;
			}
			
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			nums[cnt] = i;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
