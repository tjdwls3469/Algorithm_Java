import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10870 {
	public static int[] memo = new int[21];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fibo(Integer.parseInt(br.readLine())));
	}
	
	public static int fibo(int num) {
		if(num <= 1) {
			return  num;
		}
		if(memo[num] != 0) {
			return memo[num];
		}
		return memo[num] = fibo(num- 1) + fibo(num-2);
	}
}
