import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1931_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Data[] ary = new Data[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ary[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ary);
		int ans = 0;
		int cur = 0;
		for (int i = 0; i < N; i++) {
			if(ary[i].start >= cur) {
				cur = ary[i].end;
				ans++;
				continue;
			}
		}
		
		System.out.println(ans);
	}
	
	static class Data implements Comparable<Data> {
		public int start;
		public int end;
		
		public Data() {
		}
		
		public Data(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Data o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			
			return this.end - o.end;
		}
	}
}
