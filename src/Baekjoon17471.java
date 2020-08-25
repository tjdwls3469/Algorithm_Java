import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17471 {
	public static int N;
	public static int[] ary;
	public static ArrayList<Integer>[] list;
	public static boolean[] nums;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ary = new int[N + 1];
		list = new ArrayList[N + 1];
		nums = new boolean[N + 1];
		check = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}	// 초기화 OK
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cnt = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<Integer>();
			for (int j = 0; j < cnt; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}	// 초기화 OK
		
		int half = N / 2;
		for (int i = 1; i <= half; i++) {
			combination(0, 1, i);
		}
		System.out.println(ans);
	}
	
	public static boolean[] check;
	public static int ans = -1;
	public static int a = 0;
	public static int b = 0;
	
	private static void combination(int cnt, int start, int goal) {
		if(cnt == goal) {
			a = b = 0;
			Arrays.fill(check, false);
			
			for (int i = 1; i <= N; i++) {
				if(nums[i]) {
					dfs(i);
					break;
				}
			}
			for (int i = 1; i <= N; i++) {
				if(nums[i] && !check[i]) {
					return;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(!nums[i]) {
					dfs2(i);
					break;
				}
			}
			for (int i = 1; i <= N; i++) {
				if(!nums[i] && !check[i]) {
					return;
				}
			}
			
			if(ans == -1 || Math.abs(a - b) < ans) {
				ans = Math.abs(a - b);
			}
			
			return;
		}
		
		for (int i = start; i <= N; i++) {
			nums[i] = true;
			combination(cnt + 1, i + 1, goal);
			nums[i] = false;
		}
	}

	private static void dfs(int i) {
		check[i] = true;
		a += ary[i];
		for (int j = 0; j < list[i].size(); j++) {
			int index = list[i].get(j);
			if(!check[index] && nums[index]) {
				dfs(index);
			}
		}
	}
	
	private static void dfs2(int i) {
		check[i] = true;
		b += ary[i];
		for (int j = 0; j < list[i].size(); j++) {
			int index = list[i].get(j);
			if(!check[index] && !nums[index]) {
				dfs2(index);
			}
		}
	}
}
