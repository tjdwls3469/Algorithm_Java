import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759 {
	public static int L;
	public static int C;
	public static int LminusThree;
	public static char[] ary = new char[15];
	public static char[] result = new char[15];
	public static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		LminusThree = L - 3;
		
		String str = br.readLine();
		for (int i = 0, index = 0; i < C; i++, index += 2) {
			ary[i] = str.charAt(index);
		}
		
		Arrays.sort(ary, 0, C);
		combination(0, 0, 0, 0);
		System.out.print(ans);
	}
	
	public static void combination(int cnt, int start, int vowelCnt, int consonantCnt) {
		if(cnt == L) {		
			if(vowelCnt >= 1 && consonantCnt >= 2) {		// 최소 한 개의 모음 && 최소 두 개의 자음
				for (int i = 0; i < L; i++) {
					ans.append(result[i]);
				}
				ans.append('\n');
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			if((ary[i] == 'a' || ary[i] == 'e' || ary[i] == 'i' || ary[i] == 'o' || ary[i] == 'u')) {
				// 최소 두 개의 자음이 들어가야한다
				// 모음 개수를 한개 추가했을때 자음이 2개 들어갈 자리가 있어야한다
				// vowelCnt + 1 <= L - 2
				// vowelCnt <= L - 3
				// vowelCnt <= LminusThree
				if(vowelCnt <= LminusThree) {
					result[cnt] = ary[i];
					combination(cnt + 1, i + 1, vowelCnt + 1, consonantCnt);
				}
				continue;
			}
			result[cnt] = ary[i];
			combination(cnt + 1, i + 1, vowelCnt, consonantCnt + 1);
		}
	}
}
