import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14888 {
	private static int N;
	private static int[] num;
	private static int[] oper;
	private static boolean[] isSelected;
	private static int[] choiceOper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		num = new int[N];
		oper = new int[N-1];
		choiceOper = new int[N-1];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int cnt;
		int index = 0;
		for (int i = 1; i <= 4; i++) {
			cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				oper[index++] = i;
			}
		}
		
		permutaion(0);
		System.out.println(max + "\n" + min);
	}
	
	public static int left;
	public static int right;
	public static int result;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;

	private static void permutaion(int cnt) {
		if(cnt == N-1) {
			result = num[0];
			
			for (int i = 0; i < N-1; i++) {
				switch (choiceOper[i]) {
				case 1:
					result += num[i+1];
					break;
				case 2:
					result -= num[i+1];
					break;
				case 3:
					result *= num[i+1];
					break;
				default:
					if(result < 0) {
						result = -result;
						result /= num[i+1];
						result = -result;
						break;
					}
					result /= num[i+1];
					break;
				}
			}
			
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
			
			return;
		}
		
		for (int i = 0; i < N-1; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			choiceOper[cnt] = oper[i];
			permutaion(cnt + 1);
			isSelected[i] = false;
		}
	}
}
