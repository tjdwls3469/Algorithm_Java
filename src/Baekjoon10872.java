import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(factorial(Integer.parseInt(br.readLine())));
	}
	
	public static int factorial(int num) {
		if(num <= 1) {
			return 1;
		}
		return num * factorial(num-1);
	}
}
