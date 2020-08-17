import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon9466 {
	public static int[] nums = new int[100001];
	public static boolean[] isCycle = new boolean[100001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		int n = 0;
		int soloCnt = 0;
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();
		
		while(tc-- > 0) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}	// 초기화 OK
			
			for (int i = 1; i <= n; i++) {
				if(isCycle[i]) {	// 정점 i가 cycle에 속하면 continue
					continue;
				}
				bfs(i);
				if(i != next) {		// 시작지점(i)과 BFS탐색 후 종료지점(next)이 다르면 solo다
					isSolo[i] = true;
					soloCnt++;
				}
			}			
			ans.append(soloCnt).append('\n');
			
			soloCnt = 0;
			Arrays.fill(isCycle, 1, n + 1, false);
			Arrays.fill(isSolo, 1, n + 1, false);
		}	// end of while (tc)
		System.out.print(ans);
	}
	
	private static boolean[] isSolo = new boolean[100001];
	private static int[] from = new int[100001];	// 탐색 점정을 저장
	public static boolean[] check = new boolean[100001];
	public static int[] q = new int[100000];
	public static int front;
	public static int rear;
	public static int cur;
	public static int next;
	public static int temp;

	public static void bfs(int start) {
		front = rear = -1;
		check[start] = true;
		q[++rear] = start;
		
		while(front != rear) {
			cur = q[++front];
			next = nums[cur];
			from[next] = cur;
			
			if(next == start) {		// 다음 정점이 시작 정점이라면 cycle
				isCycle[cur] = true;
				while(from[cur] != start) {		// 사이클 정점 true로 변경
					temp = from[cur];
					isCycle[temp] = true;
					cur = temp;
				}
				break;
			}
			
			if(next == cur) {		// 가지치기 : 1 -> 3 -> 3 이런경우
				break;
			}
					
			if(isSolo[next]) {	// 가지치기 : 다음 정점이 solo라면 탈출
				break;
			}
			
			if(check[next]) {
				check[cur] = false;
				while(!check[from[cur]]) {
					temp = from[cur];
					check[temp] = false;
					cur = temp;
				}
				break;
			}
		
			check[next] = true;
			q[++rear] = next;
		}
	}
}
