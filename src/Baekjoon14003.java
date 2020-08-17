import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14003 {
	public static int[] fakeLis = new int[1000000];		// lis 길이를 구하기위한 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];	// 수열 A
		int[] trackingIndex = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		fakeLis[0] = Integer.parseInt(st.nextToken());
		A[0] = fakeLis[0];
		
		int index = 0;
		int lowerIndex = 0;
		for (int i = 1; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());	// 수열 A 초기화
			if(A[i] > fakeLis[index]) {
				fakeLis[++index] = A[i];
				trackingIndex[i] = index;
				continue;
			}
			
			lowerIndex = lowerBound(A[i], index);
			fakeLis[lowerIndex] = A[i];
			trackingIndex[i] = lowerIndex;
		}
		
//		System.out.println(Arrays.toString(A) + " // 수열 A");
//		System.out.println(Arrays.toString(trackingIndex) + " // trackingIndex");
		
		StringBuilder ans = new StringBuilder();
		int len = index + 1;
		ans.append(len).append('\n');
		
		int[] lis = new int[len];	// 스택처럼 사용
		int top = -1;
		int curIndex = index;
		
		for (int i = N - 1; i >= 0; i--) {
			if(curIndex == trackingIndex[i]) {
				lis[++top] = A[i];		// 50 -> 30 -> 20 -> 10  순서로 들어감
				curIndex--;
			}
		}
		while(top >= 0) {
			ans.append(lis[top--]).append(' ');		// 10 -> 20 -> 30 -> 50   순서로 출력
		}
		System.out.println(ans);
	}	// end of main
	
	public static int lowerBound(int key, int index) {
		int low = 0;
		int high = index;
		int mid = 0;
		
		while(low < high) {
			mid = (low + high) / 2;
			if(fakeLis[mid] >= key) {
				high = mid;
				continue;
			}
			low = mid + 1;
		}
		
		return low;
	}
}
