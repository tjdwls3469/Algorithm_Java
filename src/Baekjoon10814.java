import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Member[] ary = new Member[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			ary[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(ary);
		
		StringBuilder sb = new StringBuilder();
		for (Member member : ary) {
			sb.append(member.age).append(' ').append(member.name).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static class Member implements Comparable<Member>{
		public int age;
		public String name;
		
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member o) {
			return this.age - o.age;
		}
	}
}
