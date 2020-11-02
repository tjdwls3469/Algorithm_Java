import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2178_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] map = new String[N];
		boolean[][] check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		
		int size = N * M;
		int endX = N - 1;
		int endY = M - 1;
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		int[] qx = new int[size];
		int[] qy = new int[size];
		int[] qd = new int[size];
		int frontX, rearX, frontY, rearY, frontD, rearD;
		int fx, fy, fd, nx, ny;
		frontX = rearX = frontY = rearY = frontD = rearD = -1;
		
		check[0][0] = true;
		qx[++rearX] = 0;
		qy[++rearY] = 0;
		qd[++rearD] = 1;
		
		while(frontX != rearX){
			fx = qx[++frontX];
			fy = qy[++frontY];
			fd = qd[++frontD];
			
			if(fx == endX && fy == endY) {
				System.out.println(fd);
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				nx = fx + dx[i];
				ny = fy + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && '1' == map[nx].charAt(ny) && !check[nx][ny]) {
					check[nx][ny] = true;
					qx[++rearX] = nx;
					qy[++rearY] = ny;
					qd[++rearD] = fd + 1;
				}
			}
		}
	}
}



