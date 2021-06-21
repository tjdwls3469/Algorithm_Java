import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14502_ver2 {
	private static int blankCnt, row, col, virusCnt, calCnt, ans = Integer.MIN_VALUE;
	private static int[] nums = new int[3];
	private static int[][] map;
	@SuppressWarnings("rawtypes")
	private static ArrayList blank, virus;
	private static int[][] temp;

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		virus = new ArrayList<>();
		blank = new ArrayList<>();

		map = new int[row][col];
		check = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0) {
					blank.add(new int[] { i, j });
					continue;
				}

				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
					continue;
				}
				
			}
		}

		blankCnt = blank.size();
		virusCnt = virus.size();
		combination(0, 0);
		System.out.println(ans);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			temp = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					temp[i][j] = map[i][j];
				}
			}

			for (int i = 0; i < cnt; i++) {
				int[] point = (int[]) blank.get(nums[i]);
				temp[point[0]][point[1]] = 1;
			}

			for (int i = 0; i < row; i++) {
				Arrays.fill(check[i], false);
			}
			
			calCnt = blankCnt - 3;
			bfs();
			if(calCnt > ans) {
				ans = calCnt;
			}
			
			return;
		}

		for (int i = start; i < blankCnt; i++) {
			nums[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	public static int[] dx = new int[] { 0, -1, 0, 1 };
	public static int[] dy = new int[] { -1, 0, 1, 0 };
	private static boolean[][] check;

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < virusCnt; i++) {
			int[] point = (int[]) virus.get(i);
			q.offer(new int[] { point[0], point[1] });
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int t = 0; t < size; t++) {
				int[] cur = q.poll();
				int fx = cur[0];
				int fy = cur[1];

				for (int i = 0; i < dx.length; i++) {
					int nx = fx + dx[i];
					int ny = fy + dy[i];

					if (nx >= 0 && nx < row && ny >= 0 && ny < col && temp[nx][ny] == 0 && !check[nx][ny]) {
						check[nx][ny] = true;
						q.offer(new int[] { nx, ny });
						calCnt--;
					}
				}
			}
		}
	}
}
