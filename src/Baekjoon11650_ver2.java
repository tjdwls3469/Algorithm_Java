import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11650_ver2 {
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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ary[i].x).append(' ').append(ary[i].y).append('\n');
		}
		System.out.print(sb);
	}

	static class Data implements Comparable<Data> {
		public int x;
		public int y;

		public Data() {
		}

		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Data o) {
			if (this.x == o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
	}
}
