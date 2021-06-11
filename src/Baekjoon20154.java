import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon20154 {
	public static void main(String[] args) throws IOException {
		int[] check = new int['Z' + 1];
		check['A'] = 3;
		check['B'] = 2;
		check['C'] = 1;
		check['D'] = 2;
		check['E'] = 3;
		check['F'] = 3;
		check['G'] = 3;
		check['H'] = 3;
		check['I'] = 1;
		check['J'] = 1;
		check['K'] = 3;
		check['L'] = 1;
		check['M'] = 3;
		check['N'] = 3;
		check['O'] = 1;
		check['P'] = 2;
		check['Q'] = 2;
		check['R'] = 2;
		check['S'] = 1;
		check['T'] = 2;
		check['U'] = 1;
		check['V'] = 1;
		check['W'] = 2;
		check['X'] = 2;
		check['Y'] = 2;
		check['Z'] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> temp = new LinkedList<Integer>();
		for (int i = 0; i < len; i++) {
			q.offer(check[str.charAt(i)]);
		}
		
		while(true) {
			int cur = q.poll();
			
			if(q.isEmpty()) {
				temp.offer(cur);
				q = temp;
				if(q.size() == 1) {
					break;
				}
				
				temp = new LinkedList<Integer>();
				
				continue;
			}
			
			int next = q.poll();
			temp.offer((cur + next) % 10);
			
			if(q.isEmpty()) {
				q = temp;
				if(q.size() == 1) {
					break;
				}
				
				temp = new LinkedList<Integer>();
			}
		}
		
		int num = q.poll();
		String ans = num % 2 == 1 ? "I'm a winner!" : "You're the winner?";
		System.out.println(ans);
	}
}
