import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10814_ver2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Person[] ary = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ary[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(ary);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ary[i].age).append(' ').append(ary[i].name).append('\n');
		}
		
		System.out.print(sb);
	}

	static class Person implements Comparable<Person> {
		public int age;
		public String name;

		public Person() {
		}

		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.age - o.age;
		}
	}
}
