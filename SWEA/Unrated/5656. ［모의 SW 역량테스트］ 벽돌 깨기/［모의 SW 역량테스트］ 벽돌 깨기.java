import java.io.*;
import java.util.*;

public class Solution {

	private static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int N, W, H, min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 횟수
			W = Integer.parseInt(st.nextToken()); // 열크기
			H = Integer.parseInt(st.nextToken()); // 행크기
			int[][] map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			System.out.println("#" + tc + " " + min);
		}
	}

	// 구슬 한번 던지기
	private static boolean go(int count, int[][] map) { // 구슬이 던져진 횟수, 벽돌 맵
		// 벽돌개수 파악
		int result = getRemain(map);
		if (result == 0) {
			min = 0;
			return true;
		}

		if (count == N) {
			if (min > result)
				min = result;
			return false;
		}

		int[][] newMap = new int[H][W];

		// 모든 열에 구슬 던져보기
		for (int c = 0; c < W; c++) { // c: 구슬을 던지는 열

			// 구슬에 처음 맞는 벽돌 찾기(위쪽에서)
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;

			if (r == H)
				continue; // 맞는 벽돌이 없으면 다음 열에 던져보기

			// 배열 원본의 상태로 초기화
			copy(map, newMap);
			// 벽돌 부수기
			boom(newMap,r,c);
			// 벽돌 내리기
			down(newMap);
			// 다음 구슬 던지러 가기
			if (go(count + 1, newMap)) {
				return true;
			}
		}
		return false;
	}

	private static Deque<Integer> deque = new ArrayDeque<>();
	private static void down(int[][] map) {
		// 맨 아래행부터 위쪽 들여다보며 빈칸 만날떄마다 내려놓을 벽돌 찾기
		
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if(map[j][i]>0) {
					deque.offerLast(map[j][i]);
					map[j][i] = 0;
				}
			}
			int j = H-1;
			while(!deque.isEmpty()) {
				map[j--][i] = deque.pollLast();
			}
		}
	}

	// BFS
	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		if (map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 방문체크 : 빈공간으로 만든다.

		Point current;
		while (!queue.isEmpty()) {
			current = queue.poll();

			// 현벽돌의 cnt-1만큼 4방을 체크
			for (int i = 0; i < 4; i++) {
				int nx = current.x;
				int ny = current.y;

				for (int j = 1; j <= current.cnt - 1; j++) {
					nx += dx[i];
					ny += dy[i];
					if (!(nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] > 0)) {
						continue;
					}
					
					if (map[nx][ny] > 1) {
						queue.offer(new Point(nx, ny, map[nx][ny]));
					}
					map[nx][ny] = 0; // 방문체크 : 빈공간으로 만든다.
				}
			}

		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}