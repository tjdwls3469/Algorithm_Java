import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15686_ver2 {
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[] cx;
	private static int[] cy;
	private static int chickenCnt;
	private static int[] hx;
	private static int[] hy;
	private static int homeCnt;
	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		map = new int[N][N];
		
		int size = N*N;
		cx = new int[size];
		cy = new int[size];
		hx = new int[size];
		hy = new int[size];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					hx[homeCnt] = i;
					hy[homeCnt] = j;
					homeCnt++;
				}else if(map[i][j] == 2) {
					cx[chickenCnt] = i;
					cy[chickenCnt] = j;
					chickenCnt++;
				}
			}
		}
		
		combination(0, 0);
		System.out.println(ans);
	}
	
	public static int homeLen;
	public static int villageLen;
	public static int ans = Integer.MAX_VALUE;

	private static void combination(int cnt, int start) {
		if(cnt == M) {
			villageLen = 0;
			
			for (int i = 0; i < homeCnt; i++) {
				homeLen = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					homeLen = Math.min(Math.abs(hx[i]-cx[selected[j]]) + Math.abs(hy[i]-cy[selected[j]]), homeLen);
				}
				villageLen += homeLen;
			}
			
			if(villageLen < ans) {
				ans = villageLen;
			}
			
			return;
		}
		
		for (int i = start; i < chickenCnt; i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
