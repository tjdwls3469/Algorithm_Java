import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2512 {
	public static int M;
	public static int N;
	public static int[] ary;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			if(ary[i] > max) {
				max = ary[i];
			}
		}
		
		M = Integer.parseInt(br.readLine());
		System.out.println(binarySearch(1, max));
	}

	public static int binarySearch(int min, int max) {
		int low = min;
		int high = max;
		int limitMoney = 0;
		int sum = 0;
		
		while(low <= high) {
			limitMoney = (low + high) / 2;
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				if(ary[i] > limitMoney) {
					sum += limitMoney;
					continue;
				}
				sum += ary[i];
			}
			
			if(sum > M) {
				high = limitMoney - 1;
			}else if(sum < M) {
				low = limitMoney + 1;
			}else {
				return limitMoney;
			}
		}
		return low - 1;
	} // end of binarySearch
}
