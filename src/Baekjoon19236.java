import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon19236 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[4][4];
		Fish[] fishList = new Fish[17];
		int num;
		int dir;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				
				map[i][j] = num;
				fishList[num] = new Fish(i, j, dir);
			}
		} // 초기화 OK
		
//		Fish shark = new Fish(0, 0, fishList[map[0][0]].dir);
		Shark shark = new Shark(0, 0, fishList[map[0][0]].dir, map[0][0]);
		fishList[map[0][0]].dir = 0;
		int sum = map[0][0];
		map[0][0] = 0;
		
//		dfs(shark, fishList, map, sum);
		dfs(shark, fishList, map);
		System.out.println(ans);
	}
	
	public static int fx, fy, fd, nx, ny;
	public static int[] dx = new int[] {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = new int[] {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static int ans;
	
//	private static void dfs(Fish shark, Fish[] fishList, int[][] map, int sum) {
	private static void dfs(Shark shark, Fish[] fishList, int[][] map) {
//		if(sum > ans) {
//			ans = sum;
//		}
		if(shark.sum > ans) {
			ans = shark.sum;
		}
		
		// 물고기는 번호가 작은 물고기부터 순서대로 이동한다.
		for (int i = 1; i <= 16; i++) {
			// 죽은 물고기는 이동하지 않는다.
			if(fishList[i].dir == 0) {
				continue;
			}
			
			fx = fishList[i].x;
			fy = fishList[i].y;
			fd = fishList[i].dir;
			
			// 이동할 수 없는 칸은 상어가 있거나, 공간의 경계를 넘는 칸이다.
			int j = 0;
			for (j = 1; j <= 8; j++) {
				nx = fx + dx[fd];
				ny = fy + dy[fd];
				
				if((nx == shark.x && ny == shark.y) || nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
					fd++;
					if(fd == 9) {
						fd = 1;
					}
					fishList[i].dir = fd;
					continue;
				}
				
				break;
			}
			// 만약, 이동할 수 있는 칸이 없으면 이동을 하지 않는다.
			if(j == 9) {
				continue;
			}
			
			// 이동할 수 있는 칸은 빈 칸과 다른 물고기가 있는 칸
			// 물고기가 다른 물고기가 있는 칸으로 이동할 때는 서로의 위치를 바꾸는 방식으로 이동한다.
			int nextNum = map[nx][ny];
			int curNum = map[fx][fy];
			
			if(nextNum == 0) {
				map[nx][ny] = map[fx][fy];
				map[fx][fy] = 0;
				fishList[curNum].x = nx;
				fishList[curNum].y = ny;	
				continue;
			}
			
			map[nx][ny] = map[fx][fy];
			map[fx][fy] = nextNum;
			fishList[nextNum].x = fx;
			fishList[nextNum].y = fy;
			fishList[curNum].x = nx;
			fishList[curNum].y = ny;
		} // 물고기 이동 끝 OK
		
//		print(map);
//		print(fishList);
		
		for (int i = 1; i < 4; i++) {
			fx = shark.x;
			fy = shark.y;
			int dir = shark.dir;
			
			nx = fx + dx[dir]*i;
			ny = fy + dy[dir]*i;
			
			// 물고기가 없는 칸으로는 이동할 수 없다.
			if(nx < 0 || nx >= 4 || ny < 0 || ny >=4) {
				break;
			}
			if(map[nx][ny] == 0) {
				continue;
			}
			
			int[][] copyMap = new int[4][4];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					copyMap[j][k] = map[j][k];
				}
			}
			
			Fish[] copyFishList = new Fish[17];
			for (int j = 1; j < 17; j++) {
				copyFishList[j] = new Fish(fishList[j].x, fishList[j].y, fishList[j].dir);
			}
			
//			Fish copyShark = new Fish(shark.x, shark.y, shark.dir);
			Shark copyShark = new Shark(shark.x, shark.y, shark.dir, shark.sum);
			
			// 상어는 방향에 있는 칸으로 이동할 수 있는데, 한 번에 여러 개의 칸을 이동할 수 있다
			// 상어가 물고기가 있는 칸으로 이동했다면, 그 칸에 있는 물고기를 먹고, 그 물고기의 방향을 가지게 된다.
			// 이동하는 중에 지나가는 칸에 있는 물고기는 먹지 않는다. 
			int num = copyMap[nx][ny];
			if(num != 0) {
				copyMap[nx][ny] = 0;
				copyShark.dir = copyFishList[num].dir;
				copyShark.sum += num;
				copyFishList[num].dir = 0;
			}
			copyShark.x = copyFishList[num].x;
			copyShark.y = copyFishList[num].y;
			
//			dfs(copyShark, copyFishList, copyMap, sum + num);
			dfs(copyShark, copyFishList, copyMap);
		}
		
		// 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다. 
	}

	@SuppressWarnings("unused")
	private static void print(int[][] map) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@SuppressWarnings("unused")
	private static void print(Fish[] fishList) {
		for (int i = 1; i <= 16; i++) {
			System.out.println(fishList[i].x + " " + fishList[i].y + " " + fishList[i].dir + " ");
		}
		System.out.println();
	}

	public static class Fish {
		public int x;
		public int y;
		public int dir;
		
		public Fish(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
	}
	
	public static class Shark {
		public int x;
		public int y;
		public int dir;
		public int sum;
		
		public Shark(int x, int y, int dir, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.sum = sum;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", dir=" + dir + ", sum=" + sum + "]";
		}
	}
}