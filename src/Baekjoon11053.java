import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * D[i] : i번째 수를 마지막 요소로 가지는 LIS의 길이
 */

public class Baekjoon11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N];
		int[] lisLen = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		int temp;
		for (int i = 0; i < N; i++) {
			temp = Arrays.binarySearch(lisLen, 0, size, ary[i]);
			
			if(temp < 0) {
				temp = Math.abs(temp) - 1;
				lisLen[temp] = ary[i];
			}
			
			if(temp == size) {
				++size;
			}
		}
		
		System.out.println(size);
	}
}
