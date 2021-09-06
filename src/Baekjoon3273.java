import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon3273 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] ary = new int[n];
		for (int i = 0; i < n; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(ary);
		int left = 0;
		int right = n-1;
		int ans = 0;
		
		while(left < right) {
			if(ary[left] + ary[right] == x) {
				ans++;
				left++;
				right--;
				continue;
			}
			
			if(ary[left] + ary[right] > x) {
				right--;
				continue;
			}
			
			left++;
		}
		
		System.out.println(ans);
	}
}
