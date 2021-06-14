import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11728_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[M];
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	
		int indexA = 0;
		int indexB = 0;
		while(true) {
			if(indexA >= N || indexB >= M) {
				break;
			}
			
			if(A[indexA] <= B[indexB]) {
				sb.append(A[indexA]).append(' ');
				indexA++;
				
				continue;
			}
			
			sb.append(B[indexB]).append(' ');
			indexB++;
		}
		
		if(indexA < N) {
			for (int i = indexA; i < N; i++) {
				sb.append(A[i]).append(' ');
			}
		}
		
		if(indexB < M) {
			for (int i = indexB; i < M; i++) {
				sb.append(B[i]).append(' ');
			}
		}
		
		System.out.println(sb);
	}
}
