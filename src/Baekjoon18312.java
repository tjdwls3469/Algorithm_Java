import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18312 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int hour, min, sec;
		hour = min = sec = 0;
		int ans = 0;
		
		while(true) {
			if(hour / 10 == K || hour % 10 == K || min / 10 == K || min % 10 == K || sec / 10 == K || sec % 10 == K) {
				ans++;
			}
			
			if(hour == N && min == 59 && sec == 59) {
				break;
			}
			
			sec++;
			if(sec == 60) {
				min++;
				sec = 0;
			}
			
			if(min == 60) {
				hour++;
				min = 0;
			}
		}
		
		System.out.println(ans);
	}
}
