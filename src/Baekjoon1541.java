import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int firstMinusIndex = -1;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == '-') {
				firstMinusIndex = i;
				break;
			}
		}

		int sum = 0;
		if (firstMinusIndex == -1) {
			StringTokenizer st = new StringTokenizer(str, "+");
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			System.out.println(sum);
			return;
		}
		
		String leftStr = str.substring(0, firstMinusIndex);
		StringTokenizer st = new StringTokenizer(leftStr, "+");
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		String RightStr = str.substring(firstMinusIndex + 1, len);
		st = new StringTokenizer(RightStr, "+");
		while(st.hasMoreTokens()) {
			StringTokenizer st1 = new StringTokenizer(st.nextToken(), "-");
			while(st1.hasMoreTokens()) {
				sum -= Integer.parseInt(st1.nextToken());
			}
		}
		
		System.out.println(sum);
	}
}
