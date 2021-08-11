import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] ary = new int[1001];
		int index = 1;
		
ex:		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < i; j++) {
				ary[index] = i;
				index++;
				
				if(index == 1001) {
					break ex;
				}
			}
		}
		
		int ans = 0;
		for (int i = A; i <= B; i++) {
			ans += ary[i];
		}
		
		System.out.println(ans);
	}
}
