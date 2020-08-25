import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon13171 {
	public static int mod = 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(br.readLine()) % mod;
		long x = Long.parseLong(br.readLine());
		long ans = 1;
		
	    while(x != 0){
	        if((x & 1) == 1) {
	        	ans = (ans * a) % mod;
	        }
	        x >>= 1;
	        a = (a * a) % mod; 
	    }
	    System.out.println(ans);
	}
}