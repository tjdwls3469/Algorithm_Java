import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2961 {
	public static int[] sourList = new int[10];
	public static int[] bitterList = new int[10];
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sourList[i] = Integer.parseInt(st.nextToken());
			bitterList[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			M = i;
			combination(0, 0, 1, 0);
		}
		System.out.println(ans);
	}
	
	public static int[] index = new int[10];
	public static int M = 1;
	public static int diff;
	public static int ans = Integer.MAX_VALUE;
	
	public static void combination(int cnt, int start, int sourMul, int bitterSum) {
		if(cnt == M) {
			diff = sourMul - bitterSum;
			if(diff < 0) {
				diff = -diff;
			}
			if(diff < ans) {
				ans = diff;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			index[cnt] = i;
			combination(cnt + 1, i + 1, sourMul*sourList[index[cnt]], bitterSum+bitterList[index[cnt]]);
		}
	}
}
