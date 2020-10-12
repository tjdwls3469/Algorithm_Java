import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon19236 {
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		MAP[][] map = new MAP[4][4];
		Fish[] fishInfo = new Fish[17];
		
		int num;
		int dir;
		
		for (int i = 0; i < 4; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				
				map[i][j] = new MAP(num, dir);
				fishInfo[num] = new Fish(i, j, dir, num, false);
			}
		}
		// map 초기화 OK
		
		Shark shark = new Shark(0, 0, map[0][0].getDir(), map[0][0].getNum());
		fishInfo[map[0][0].getNum()].setDeath(true);
		map[0][0].setNum(0);
		map[0][0].setDir(0);
		
		dfs(shark, map, fishInfo);
		System.out.println(ans);
	}
	
	public static int[] dx = new int[] {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = new int[] {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static MAP[][] copyMap = new MAP[4][4];
	
	private static void dfs(Shark shark, MAP[][] map, Fish[] fishInfo) {
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyMap[i][j] = new MAP(map[i][j].num, map[i][j].dir);
			}
		}
		
		// 물고기 이동
		for (int i = 1; i <= 16; i++) {
			if(fishInfo[i].getDeath()) {
				continue;
			}
			
			// 물고기가 살아 있다면
			for (int j = 0; j < 8; j++) {
				int nx = fishInfo[i].x + dx[fishInfo[i].dir];
				int ny = fishInfo[i].y + dy[fishInfo[i].dir];
				if((nx == shark.x && ny == shark.y) || nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
					fishInfo[i].dir++;
					System.out.println("fishInfo[i].dir : " + fishInfo[i].dir);
					if(fishInfo[i].dir == 9) {
						System.out.println("dir 9일때 번호 : " + i);
						fishInfo[i].dir = 1;
					}
					copyMap[fishInfo[i].x][fishInfo[i].y].dir = fishInfo[i].dir;
					continue;
				}
				
				System.out.println(i + "번 물고기");
				System.out.println("fishInfo[i].dir : " + fishInfo[i].dir);
				
				int curMapNum = copyMap[fishInfo[i].x][fishInfo[i].y].num;
				int curMapDir = copyMap[fishInfo[i].x][fishInfo[i].y].dir;
				int nextMapNum = copyMap[nx][ny].num;
				int nextMapDir = copyMap[nx][ny].dir;
				
				int curFishX = fishInfo[i].x;
				int curFishY = fishInfo[i].y;
				int curFishNum = fishInfo[i].num;
				int curFishDir = fishInfo[i].dir;
				int nextFishX = fishInfo[nextMapNum].x;
				int nextFishY = fishInfo[nextMapNum].y;
				int nextFishNum = fishInfo[nextMapNum].num;
				int nextFishDir = fishInfo[nextMapNum].dir;
				
				copyMap[fishInfo[i].x][fishInfo[i].y].num = nextMapNum;
				copyMap[fishInfo[i].x][fishInfo[i].y].dir = nextMapDir;
				copyMap[nx][ny].num = curMapNum;
				copyMap[nx][ny].dir = curMapDir;

				fishInfo[i].x = nextFishX;
				fishInfo[i].y = nextFishY;
				fishInfo[i].num = nextFishNum;
				fishInfo[i].dir = nextFishDir;
				
				fishInfo[nextMapNum].x = curFishX;
				fishInfo[nextMapNum].y = curFishY;
				fishInfo[nextMapNum].num = curFishNum;
				fishInfo[nextMapNum].dir = curFishDir;
				
				
				System.out.println(i + "번 물고기 이동후");
				print(copyMap);
				System.out.println();
				
				break;
				
				
			}
		} // 물고기 이동 끝
		
		

		
		// 상어이동
		for (int i = 0; i < 4; i++) {
			int nx = shark.x + dx[shark.dir];
			int ny = shark.y + dy[shark.dir];
			
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
				break;
			}
			
			if(copyMap[nx][ny].num == 0) {
				continue;
			}
			
			shark.x = nx;
			shark.y = ny;
			shark.eatNumSum += copyMap[nx][ny].num;
			shark.dir = copyMap[nx][ny].dir;
			fishInfo[copyMap[nx][ny].num].death = true;
			copyMap[nx][ny].num = 0;
			
			dfs(shark, copyMap, fishInfo);
		}
		
		// 상어 이동 끝
		if(shark.eatNumSum > ans) {
			ans = shark.eatNumSum;
		}
	}

	public static class MAP {
		public int num;
		public int dir;
		
		public MAP(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Fish [num=" + num + ", dir=" + dir + "]";
		}
	}
	
	public static class Shark {
		public int x;
		public int y;
		public int dir;
		public int eatNumSum;
		
		public Shark(int x, int y, int dir, int eatNumSum) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.eatNumSum = eatNumSum;
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

		public int getEatNumSum() {
			return eatNumSum;
		}

		public void setEatNumSum(int eatNumSum) {
			this.eatNumSum = eatNumSum;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", dir=" + dir + ", eatNumSum=" + eatNumSum + "]";
		}
	}
	
	public static class Fish {
		public int x;
		public int y;
		public int dir;
		public int num;
		public boolean death;
		
		public Fish(int x, int y, int dir, int num, boolean death) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.num = num;
			this.death = death;
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
		
		public boolean getDeath() {
			return death;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public boolean isDeath() {
			return death;
		}

		public void setDeath(boolean death) {
			this.death = death;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + ", num=" + num + ", death=" + death + "]";
		}
	}
	
	public static void print(MAP[][] map) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(map[i][j].num + " ");
			}
			System.out.println();
		}
	}
}
