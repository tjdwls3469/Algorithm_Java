

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2292 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(execute(N));
	}
	
	public static int execute(int N) {
		// 구현하세요.
		if(N == 1) { // N이 1이면
			return 1; // 1리턴
		} // end of if
		// 공백
		int cnt = 1; // 1에서 N까지 몇번에 갈수 있는지 나타내는 변수
		int num = 2; // 2, 8, 20, 38... 씩 변하여 값을 추론하게 해주는 변수
		int mul = 1; // 개수를 1개씩 증가시켜서 6, 12, 18... 이런식으로 곱하려고 사용
		while(true) { // start of while
			if(num > N) { // num이 N보다 크면
				break; // while문 탈출
			} // end of while
			num += 6*mul; // 2, 8, 20, 38... 씩 변한다
			mul++; // 1 증가
			cnt++; // 1 증가
		} // end of while
		// 공백
		return cnt; // 리턴값을 수정하세요
	}
}
