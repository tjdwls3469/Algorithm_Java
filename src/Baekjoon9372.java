import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	신장 트리
//	- n개의 정점으로 이루어진 무향 그래프에서
//	  n개의 정점과 n-1개의 간선으로 이루어진 트리
//	- n개의 정점 모두를 이어붙이는데
//	     최소의 간선(n-1)개만 사용한 트리
//	- 싸이클 x 

public class Baekjoon9372 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int M = 0;
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) - 1).append('\n');
			M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				br.readLine();
			}
		}
		
		System.out.print(sb);
	}
}
