import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, N, M, result, map[][];
	static boolean isSucess;

	static int[][] knight = { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 2, 1 }, { 1, 2 }, { 2, -1 }, { 1, -2 } };
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static class Point {
		int x, y, k;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		if (!isSucess) {
			result = -1;
		}
		System.out.println(result);
	}

	static boolean visited[][][];

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0, K));

		while (!q.isEmpty()) {

			int size = q.size();

			while (size-- > 0) {
				Point now = q.poll();
				if (now.x == N - 1 && now.y == M - 1) {
					isSucess = true;
					return;
				}



				for (int d = 0; d < 4; d++) {
					int nx = now.x + delta[d][0];
					int ny = now.y + delta[d][1];

					if (!(nx >= 0 && ny >= 0 && nx < N && ny < M)) {
						continue;
					}
					if (map[nx][ny] == 1 || visited[nx][ny][now.k])
						continue;
					visited[nx][ny][now.k] = true;
					q.offer(new Point(nx, ny, now.k));
				}
				
				if (now.k>0) {
					for (int d = 0; d < 8; d++) {
						int nx = now.x + knight[d][0];
						int ny = now.y + knight[d][1];

						if (!(nx >= 0 && ny >= 0 && nx < N && ny < M)) {
							continue;
						}

						if (map[nx][ny] == 1 || visited[nx][ny][now.k-1])
							continue;

						visited[nx][ny][now.k-1] = true;
						q.offer(new Point(nx, ny, now.k -1));
					}
				}

			}
			result++;
		}

	}

}