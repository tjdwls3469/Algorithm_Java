import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][col];
		
		int rc = row * col * 2;
		int[] qx = new int[rc];
		int[] qy = new int[rc];
		int[] qd = new int[rc];
		char[] qc = new char[rc];
		int frontX = -1;
		int frontY = -1;
		int frontD = -1;
		int frontC = -1;
		int rearX = -1;
		int rearY = -1;
		int rearD = -1;
		int rearC = -1;
		int fx = 0;
		int fy = 0;
		int fd = 0;
		char fc = '\u0000';
		int nx = 0;
		int ny = 0;
		int endX = 0;
		int endY = 0;
		int startX = 0;
		int startY = 0;
		
		String str = "";
		for (int i = 0; i < row; i++) {
			str = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D') {
					endX = i;
					endY = j;
				} else if(map[i][j] == '*') {
					qx[++rearX] = i;
					qy[++rearY] = j;
					qd[++rearD] = 0;
					qc[++rearC] = '*';
				} else if(map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}		// map 초기화 OK
		
		qx[++rearX] = startX;
		qy[++rearY] = startY;
		qd[++rearD] = 0;
		qc[++rearC] = 'S';
		
		int dx[] = {0, -1, 0, 1};
		int dy[] = {-1, 0, 1, 0};

		while(rearX != frontX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			fd = qd[++frontD];
			fc = qc[++frontC];
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
					if(fc == '*' && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						map[nx][ny] = '*';
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = fd + 1;
						qc[++rearC] = fc;
						continue;
					}
					if(fc == 'S' && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						if(nx == endX && ny == endY) {
							System.out.println(fd + 1);
							return;
						}
						map[nx][ny] = 'S';
						qx[++rearX] = nx;
						qy[++rearY] = ny;
						qd[++rearD] = fd + 1;
						qc[++rearC] = fc;
					}
				}
			}
		}		// end of BFS
		System.out.println("KAKTUS");
	}
}
