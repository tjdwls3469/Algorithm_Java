import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15686 {
	public static int[] index;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] homeX = new int[2*N];
		int[] homeY = new int[2*N];
		int homeCnt = 0;
		
		int[] kyochonX = new int[13];
		int[] kyochonY = new int[13];
		int kyochonCnt = 0;
		
		char[][] map = new char[N][N];
		String line = "";
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0, index = 0; j < N; j++, index += 2) {
				map[i][j] = line.charAt(index);
				switch(map[i][j]) {
				case '1':
					homeX[homeCnt] = i;
					homeY[homeCnt] = j;
					homeCnt++;
					break;
				case '2':
					kyochonX[kyochonCnt] = i;
					kyochonY[kyochonCnt] = j;
					kyochonCnt++;
					break;
				}
			}
		}	// map 초기화 OK
		
		index = new int[kyochonCnt];	// nextPermutation에서 사용
		int cnt = 0;
		int ans = Integer.MAX_VALUE;
		
		for (int selectCnt = 1; selectCnt <= M; selectCnt++) {	// 치킨집 1 ~ M개까지 선택
			Arrays.fill(index, 0);
			cnt = 0;
			while (++cnt <= selectCnt) {
				index[kyochonCnt - cnt] = 1;	// selectCnt만큼 뒤에서부터 1로 초기화
			}	// OK
			
			do {
				int cityMin = 0;	// 치킨집과 모든 집과의 거리
				for (int i = 0; i < homeCnt; i++) {
					int curHomeMin = Integer.MAX_VALUE;
					
					for (int j = 0; j < index.length; j++) {
						if (index[j] == 0) {	// 선택된 치킨집이 아니면 continue
							continue;
						}
						
						int val = Math.abs(homeX[i] - kyochonX[j]) + Math.abs(homeY[i] - kyochonY[j]);
						if(val < curHomeMin) {
							curHomeMin = val;
						}
					}
					
					cityMin += curHomeMin;
				}	// end of for (homeCnt)
				
				if(cityMin < ans) {		// 현재 상황에서 도시의 치킨거리가 ans보다 작으면 업데이트
					ans = cityMin;
				}
			} while (nextPermutaion());
		}	// end of for (치킨집 1 ~ M개까지 선택)
		System.out.println(ans);
	}	// end of main
	
	public static boolean nextPermutaion() {
		int i = index.length - 1;
		while(i > 0 && index[i - 1] >= index[i]) --i;
		if (i == 0) return false;
		
		int j = index.length - 1;
		while(index[i - 1] >= index[j]) --j;
		
		int temp = index[i - 1];
		index[i - 1] = index[j];
		index[j] = temp;
		
		int k = index.length - 1;
		while(i < k) {
			temp = index[i];
			index[i] = index[k];
			index[k] = temp;
			i++;
			k--;
		}
		
		return true;
	}
}
