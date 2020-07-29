import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jungol2514 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String data = br.readLine();
		int koi = 0;
		int ioi = 0;
		for (int i = 0; i < data.length()-2; i++) {
			sb.append(data.charAt(i)).append(data.charAt(i+1)).append(data.charAt(i+2));
			
			if("IOI".equals(sb.toString())) {
				ioi++;
			}
			else if("KOI".equals(sb.toString())) {
				koi++;
			}
			sb.setLength(0); 
			
		}
		System.out.println(koi + "\n" + ioi);
	}
}
