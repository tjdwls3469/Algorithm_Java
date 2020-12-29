import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch (st.nextToken()) {
			case "push_front":
				q.offerFirst(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_back":
				q.offerLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
					break;
				}
				
				sb.append(q.pollFirst()).append('\n');
				break;
				
			case "pop_back":
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
					break;
				}
				
				sb.append(q.pollLast()).append('\n');
				break;
				
			case "size":
				sb.append(q.size()).append('\n');
				break;
				
			case "empty":
				if(q.isEmpty()) {
					sb.append(1).append('\n');
					break;
				}
				
				sb.append(0).append('\n');
				break;
				
			case "front":
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
					break;
				}
				
				sb.append(q.peekFirst()).append('\n');
				break;

			default:
				if(q.isEmpty()) {
					sb.append(-1).append('\n');
					break;
				}
				
				sb.append(q.peekLast()).append('\n');
				break;
			}
		} // end of for
		System.out.print(sb);
	}
}
