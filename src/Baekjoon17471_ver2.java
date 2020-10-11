import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17471_ver2 {
	public static int goal;
	private static int N;
	private static int[] peopleCnt;
	private static boolean[] isSelected;
	private static boolean[] check;
	private static ArrayList<Integer>[] adjList;
	private static int ans = -1;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		peopleCnt = new int[N+1];
		isSelected = new boolean[N+1];
		check = new boolean[N+1];
		adjList = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			peopleCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cnt = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<Integer>();
			for (int j = 0; j < cnt; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int end = N/2;
		for (int i = 1; i <= end; i++) {
			goal = i;
			combination(0, 1);
		}
		System.out.println(ans);
	}
	
	public static int a, b;

	private static void combination(int cnt, int start) {
		if(cnt == goal) {
			a = b = 0;
			
			Arrays.fill(check, false);
			
			for (int i = 1; i <= N; i++) {
				if(isSelected[i]) {
					dfs(i);
					break;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(isSelected[i] && !check[i]) {
					return;
				}
			}
			
			Arrays.fill(check, false);
			
			for (int i = 1; i <= N; i++) {
				if(!isSelected[i]) {
					dfs2(i);
					break;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(!isSelected[i] && !check[i]) {
					return;
				}
			}
			
			int diff = Math.abs(a - b);
			if(ans == -1 || diff < ans) {
				ans = diff;
			}
			
			return;
		}
		
		for (int i = start; i <= N; i++) {
			isSelected[i] = true;
			combination(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

	private static void dfs(int cur) {
		check[cur] = true;
		a += peopleCnt[cur];
		
		int next;
		for (int i = 0; i < adjList[cur].size(); i++) {
			next = adjList[cur].get(i);
			if(!check[next] && isSelected[next]) {
				dfs(next);
			}
		}
	}
	
	private static void dfs2(int cur) {
		check[cur] = true;
		b += peopleCnt[cur];
		
		int next;
		for (int i = 0; i < adjList[cur].size(); i++) {
			next = adjList[cur].get(i);
			if(!check[next] && !isSelected[next]) {
				dfs2(next);
			}
		}
	}
}
