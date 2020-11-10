import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1325 {
	public static ArrayList<Integer>[] adjList;
	public static int[] resultAry;
	public static int[] from;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A, B;
		int size = N+1;
		resultAry = new int[size];
		adjList = new ArrayList[size];
		check = new boolean[size];
		totalMax = 1;
		for (int i = 0; i < size; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			adjList[B].add(A);
		}
		
		for (int i = 1; i <= N; i++) {
			max = 1;
			dfs(i, 1);
			resultAry[i] = max;
			
			if(max > totalMax) {
				totalMax = max;
			}
		} // end of for
		
		for (int i = 1; i <= N; i++) {
//			System.out.println("num: " + i + " cnt: " + resultAry[i]);
			if(resultAry[i] == totalMax) {
				sb.append(i).append(' ');
			}
		}
		
		System.out.print(sb);
	} // end of main

	public static int listSize, next, max, totalMax;
	public static boolean[] check;
	
	private static void dfs(int cur, int cnt) {
		System.out.println(cur);
		listSize = adjList[cur].size();
		check[cur] = true;
		for (int i = 0; i < listSize; i++) {
			next = adjList[cur].get(i);
			if(!check[next]) {
				dfs(next, cnt + 1);
			}
		}
	}
}
