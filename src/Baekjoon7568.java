import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Person[] ary = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ary[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int i = 0; i < N; i++) {
			num = 1;
			
			for (int j = 0; j < N; j++) {
				if(ary[i].kg < ary[j].kg && ary[i].cm < ary[j].cm) {
					num++;
				}
			}
			
			sb.append(num).append(' ');
		}
		System.out.println(sb);
	}

	static class Person {
		public int kg;
		public int cm;

		public Person() {
		}

		public Person(int kg, int cm) {
			super();
			this.kg = kg;
			this.cm = cm;
		}
	}
}
