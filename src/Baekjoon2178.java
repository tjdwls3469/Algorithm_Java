import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//char[][] map = new char[row][col];
//check배열 대신 map에서 방문했으면 '1'을 '0'으로 바꾸기

public class Baekjoon2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[row][col];
		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int size = row * col;
		int[] qx = new int[size];
		int[] qy = new int[size];
		int[] qd = new int[size];
		int frontX = -1;
		int frontY = -1;
		int frontD = -1;
		int rearX = -1;
		int rearY = -1;
		int rearD = -1;
		int fx = 0;
		int fy = 0;
		int fd = 0;
		int nx = 0;
		int ny = 0;
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		map[fx][fy] = '0';
		qx[++rearX] = 0;
		qy[++rearY] = 0;
		qd[++rearD] = 1;
		
		int endX = row -1;
		int endY = col -1;
		
		while(rearX != frontX) {
			fx = qx[++frontX];
			fy = qy[++frontY];
			fd = qd[++frontD];
			
			if(fx == endX && fy == endY) {
				System.out.println(fd);
				return;
			}
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < row && ny >= 0 && ny < col && map[nx][ny] == '1') {
					map[nx][ny] = '0';
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					qd[++rearD] = fd + 1;
				}
			}
		}
	}
}
