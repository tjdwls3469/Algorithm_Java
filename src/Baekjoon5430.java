import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		String p, ary;
		int n, len;
		Deque<Integer> q = new LinkedList<Integer>();
		boolean reverse, check;
		
		for (int tc = 0; tc < T; tc++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			ary = br.readLine();
			q.clear();
			
			ary = ary.substring(1, ary.length() - 1);
			if(n == 0) {
				if(p.contains("D")) {
					sb.append("error").append('\n');
					continue;
				}
				
				sb.append("[]").append('\n');
				continue;
			}
			
			st = new StringTokenizer(ary, ",");
			for (int i = 0; i < n; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			len = p.length();
			check = reverse = false;
			
			for (int i = 0; i < len; i++) {
				if(p.charAt(i) == 'R') {
					reverse = !reverse;
					continue;
				}
				
				if(q.isEmpty()) {
					check = true;
					sb.append("error").append('\n');
					break;
				}
				
				if(reverse) {
					q.pollLast();
				}else {
					q.pollFirst();
				}
			} // end of for
			
			if(!check) {
				if(q.isEmpty()) {
					sb.append("[]").append('\n');
					continue;
				}
				
				sb.append('[');
				if(reverse) {
					while(!q.isEmpty()) {
						sb.append(q.pollLast()).append(',');
					}
				}else {
					while(!q.isEmpty()) {
						sb.append(q.pollFirst()).append(',');
					}
				}
				sb.deleteCharAt(sb.lastIndexOf(",")).append(']').append('\n');
			}
		} // end of TC
		System.out.print(sb);
	}
}
