

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int cnt = Integer.parseInt(br.readLine());
		int[][] shops = new int[cnt][2];
		
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			shops[i][0] = Integer.parseInt(st.nextToken());
			shops[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int dongDir = Integer.parseInt(st.nextToken());
		int dongPoint = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		switch (dongDir) {
		case 1:
			for (int i = 0; i < cnt; i++) {
				switch (shops[i][0]) {
				case 1:
					ans += Math.abs(dongPoint - shops[i][1]);
					break;
					
				case 2:
					ans += Math.min( (dongPoint + shops[i][1]), (col-dongPoint) + (col-shops[i][1]) ) + row;
					break;
					
				case 3:
					ans += dongPoint + shops[i][1];
					break;

				default:
					ans += (col - dongPoint) + shops[i][1];
					break;
				}
			}
			
			break;
			
		case 2:
			for (int i = 0; i < cnt; i++) {
				switch (shops[i][0]) {
				case 1:
					ans += Math.min( (dongPoint + shops[i][1]), (col-dongPoint) + (col-shops[i][1]) ) + row;
					break;
					
				case 2:
					ans += Math.abs(dongPoint - shops[i][1]);
					break;
					
				case 3:
					ans += dongPoint + (row - shops[i][1]);
					break;

				default:
					ans += (col - dongPoint) + (row - shops[i][1]);
					break;
				}
			}
			
			break;
			
		case 3:
			for (int i = 0; i < cnt; i++) {
				switch (shops[i][0]) {
				case 1:
					ans += dongPoint + shops[i][1];
					break;
					
				case 2:
					ans += (row - dongPoint) + shops[i][1];
					break;
					
				case 3:
					ans += Math.abs(dongPoint - shops[i][1]);
					break;

				default:
					ans += Math.min( (dongPoint + shops[i][1]), (row-dongPoint) + (row-shops[i][1]) ) + col;
					break;
				}
			}
			
			break;

		default:
			for (int i = 0; i < cnt; i++) {
				switch (shops[i][0]) {
				case 1:
					ans += dongPoint + (col - shops[i][1]);
					break;
					
				case 2:
					ans += (row - dongPoint) + (col - shops[i][1]);
					break;
					
				case 3:
					ans += Math.min( (dongPoint + shops[i][1]), (row-dongPoint) + (row-shops[i][1]) ) + col;
					break;

				default:
					ans += Math.abs(dongPoint - shops[i][1]);
					break;
				}
			}
			
			break;
		} // end of sitch
		System.out.println(ans);
	} // end of main
}
