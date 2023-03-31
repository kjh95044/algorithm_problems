import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M, result;
	static char[][] map;
	static boolean[][][] visited;
	static char[] keys = { 'a', 'b', 'c', 'd', 'e', 'f' };

	static HashMap<Character, List<Point>> lockedDoors;

	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y, flag, moveCnt;

		public Point(int x, int y, int flag, int moveCnt) {
			this.x = x;
			this.y = y;
			this.flag = flag;
			this.moveCnt = moveCnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;

		map = new char[N][M];
		visited = new boolean[N][M][64];
		Point start = null;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					map[i][j] = '.';
					start = new Point(i, j, 0, 0);
				}
			}
		}

		result = bfs(start);

		sb.append(result).append("\n");

		System.out.println(sb);
	}

	private static int bfs(Point p) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(p);
		visited[p.x][p.y][p.flag] = true;

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {
				Point now = queue.poll();


				// 사방탐색
				for (int d = 0; d < 4; d++) {
					int nx = now.x + delta[d][0];
					int ny = now.y + delta[d][1];

					if (!(nx >= 0 && nx < N && ny >= 0 && ny < M)) { // 범위 밖이면
						continue;
					}
					
					

					char np = map[nx][ny]; // np : next place
					
					if(np=='1') {
						return now.moveCnt + 1;
					}

					if (visited[nx][ny][now.flag] || np == '#') { // 방문했거나, 벽이면 pass
						continue;
					}

					if (np == '.') { // 빈공간이면
						visited[nx][ny][now.flag] = true;
						queue.offer(new Point(nx, ny, now.flag, now.moveCnt + 1));
					}

					else if (Character.isUpperCase(np)) { // 문을 발견하면 열쇠로 열수 있는지 확인
						int index = np - 'A'; // flag 인덱스

						if ((now.flag & (1<<index)) != 0) { // 열쇠가 있다.
							visited[nx][ny][now.flag] = true;
							queue.offer(new Point(nx, ny, now.flag, now.moveCnt + 1));
						}

					} else if (Character.isLowerCase(np)) { // 열쇠 발견하면 열쇠 넣고, 열쇠가 없어서 못열던 문 다시 확인
						int index = np - 'a'; // flag 인덱스
						int flag = now.flag | (1 << index);
						queue.offer(new Point(nx, ny, flag, now.moveCnt + 1));
						visited[nx][ny][flag] = true;

					}

				}
			}
		}
		return -1;
	}

}