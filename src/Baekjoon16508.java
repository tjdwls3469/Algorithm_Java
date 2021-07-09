import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16508 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		int[] price = new int[N];
		String[] book = new String[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			price[i] = Integer.parseInt(st.nextToken());
			book[i] = st.nextToken();
		}
		
		int len = T.length();
		boolean[] check = new boolean[N];
		for (int t = 0; t < len; t++) {
			char ch = T.charAt(t);
			int index = -1;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				if(!book[i].contains(ch + "")) {
					continue;
				}
				
				if(price[i] < min) {
					min = price[i];
					index = i;
				}
			}
			
			if(index == -1) {
				continue;
			}
			
			check[index] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(!check[i]) {
				continue;
			}
			
			ans += price[i];
		}
		
		if(ans == 0) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
}
