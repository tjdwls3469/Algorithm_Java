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
		int pushNum = 0;
		int num;
		
		for (int i = 1; i <= n; i++) {
			num = Integer.parseInt(br.readLine());
			if(pushNum < num) {
				for (int j = pushNum; j < num; j++) {
					sb.append('+').append('\n');
					stack[++top] = ++pushNum;
				}
				sb.append('-').append('\n');
				top--;
			}else if(pushNum >= num) {
				while(top != -1) {
					sb.append('-').append('\n');
					if(stack[top--] == num) {
						break;
					}else {
						System.out.println("NO");
						System.exit(0);
					}
				}
			}
		}
		System.out.print(sb);
	}
}
