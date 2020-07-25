import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2920 {
	public static final int CNT = 8;
	public static int[] num = new int[CNT];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int index = 0;
		while(st.hasMoreTokens()) {
			num[index++] = Integer.parseInt(st.nextToken());
		}
		switch (num[0]) {
		case 1:
			for (int i = 1; i < CNT; i++) {
				if(num[i] - num[i-1] != 1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
			break;
		case 8:
			for (int i = 1; i < CNT; i++) {
				if(num[i] - num[i-1] != -1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			break;
		default:
			System.out.println("mixed");
			return;
		}
	}
}
