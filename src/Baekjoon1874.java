import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		int top = -1;
		int pushNum = 1;
		
		int num = 0;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			
			if(top != -1 && stack[top] > num) {
				break;
			}
			
			for (int j = pushNum; j <= num; j++, pushNum++) {
				sb.append('+').append('\n');
				stack[++top] = j;
			}
			sb.append('-').append('\n');
			top--;
		}
		
		if(top == -1) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}
}
