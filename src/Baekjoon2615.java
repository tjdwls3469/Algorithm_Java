import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2615 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ansColor = 0;
		int x = 0;
		int y = 0;
ex:		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(map[i][j] == 0) {
					continue;
				}
				
				if(j+4 < 19 && map[i][j+1] == map[i][j] && map[i][j+2] == map[i][j] && map[i][j+3] == map[i][j] && map[i][j+4] == map[i][j]) {
					if((j+5 < 19 && map[i][j+5] == map[i][j]) || (j-1 >= 0 && map[i][j-1] == map[i][j])) {
						continue;
					}
					
					ansColor = map[i][j];
					x = i+1;
					y = j+1;
					break ex;
				}
				
				if(i+4 < 19 && map[i+1][j] == map[i][j] && map[i+2][j] == map[i][j] && map[i+3][j] == map[i][j] && map[i+4][j] == map[i][j]) {
					if((i+5 < 19 && map[i+5][j] == map[i][j]) || (i-1 >= 0 && map[i-1][j] == map[i][j])) {
						continue;
					}
					
					ansColor = map[i][j];
					x = i+1;
					y = j+1;
					break ex;
				}
				
				if(i+4 < 19 && j+4 < 19 && map[i+1][j+1] == map[i][j] && map[i+2][j+2] == map[i][j] && map[i+3][j+3] == map[i][j] && map[i+4][j+4] == map[i][j]) {
					if((i+5 < 19 && j+5 < 19 && map[i+5][j+5] == map[i][j]) || (i-1 >= 0 && j-1 >= 0 && map[i-1][j-1] == map[i][j])) {
						continue;
					}
					
					ansColor = map[i][j];
					x = i+1;
					y = j+1;
					break ex;
				}
				
				if(i-4 >= 0 && j+4 < 19 && map[i-1][j+1] == map[i][j] && map[i-2][j+2] == map[i][j] && map[i-3][j+3] == map[i][j] && map[i-4][j+4] == map[i][j]) {
					if((i-5 >= 0 && j+5 < 19 && map[i-5][j+5] == map[i][j]) || (i+1 < 19 && j-1 >= 0 && map[i+1][j-1] == map[i][j])) {
						continue;
					}
					
					ansColor = map[i][j];
					x = i+1;
					y = j+1;
					break ex;
				}
			}
		} // end of for
		
		if(ansColor == 0) {
			System.out.println(0);
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append(ansColor).append('\n').append(x).append(' ').append(y);
			System.out.println(sb);
		}
	}
}
