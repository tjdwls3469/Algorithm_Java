import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 맵 초기화 방법
 * char[][] map = new char[row][col];
 * str = br.readLine();
 * for (int j = 0, index = 0; j < col; j++, index+=2) {
 *     map[i][j] = str.charAt(index);
 * }
 */

public class Baekjoon1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][col];
		
		String str = "";
		for (int i = 0; i < row; i++) {
			str = br.readLine();
			for (int j = 0, index = 0; j < col; j++, index+=2) {
				map[i][j] = str.charAt(index);
			}
		}	// map 초기화 OK
		
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		boolean[][] check = new boolean[row][col];
		int[] qx = new int[250000];
		int[] qy = new int[250000];
		int frontX = -1;
		int rearX = -1;
		int frontY = -1;
		int rearY = -1;
		int fx = 0;
		int fy = 0;
		int nx = 0;
		int ny = 0;
		int paintingCnt = 0;
		int curWidth = 0;
		int maxWidth = Integer.MIN_VALUE;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j] == '1' && !check[i][j]) {
					curWidth = 0;
					paintingCnt++;
					
					frontX = rearX = frontY = rearY =  -1;
					check[i][j] = true;
					qx[++rearX] = i;
					qy[++rearY] = j;
					
					while(rearX != frontX) {
						curWidth++;
						fx = qx[++frontX];
						fy = qy[++frontY];
						
						for (int k = 0; k < dx.length; k++) {
							nx = fx + dx[k];
							ny = fy + dy[k];
							
							if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == '1' && !check[nx][ny]) {
								check[nx][ny] = true;
								qx[++rearX] = nx;
								qy[++rearY] = ny;
							}
						}
					}
				}	// end of BFS
				if(curWidth > maxWidth) {
					maxWidth = curWidth;
				}
			}
		}	// end of 이중 for문
		System.out.println(paintingCnt + "\n" + maxWidth);
	}
}
