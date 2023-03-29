import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, result;
	static int[][] map;
	static final int 가로 = 1, 세로 = 2, 대각선 = 3;

	static class Pipe {
		int type, x, y;

		public Pipe(int type, int x, int y) {
			super();
			this.type = type;
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		System.out.println(result);
	}

	static int[][] delta = {{0,1},{1,1},{1,0}}; // 오른쪽, 오른쪽아래, 아래
	
	private static void bfs() {
		Queue<Pipe> queue = new ArrayDeque<>();
		queue.offer(new Pipe(가로, 0, 1));

		while (!queue.isEmpty()) {
			Pipe now = queue.poll();
			if(now.x == N-1 && now.y == N-1) {
				result++;
				continue;
			}
			
			int nx=now.x , ny=now.y;
			
			switch (now.type) {
			case 가로:
				if(ny+1<N && map[nx][ny+1] != 1) {
					queue.offer(new Pipe(가로,nx,ny+1));
				}
				
				if(ny+1<N && nx+1<N && map[nx][ny+1] != 1 && map[nx+1][ny+1] != 1 && map[nx+1][ny] != 1) { // 오른쪽, 오른쪽 아래, 아래 전부다 비어있음
					queue.offer(new Pipe(대각선,nx+1,ny+1));
				}
				break;
			case 세로:
				if(nx+1 < N && map[nx+1][ny] != 1) {
					queue.offer(new Pipe(세로,nx+1,ny));
				}
				
				if(ny+1<N && nx+1<N && map[nx][ny+1] != 1 && map[nx+1][ny+1] != 1 && map[nx+1][ny] != 1) { // 오른쪽, 오른쪽 아래, 아래 전부다 비어있음
					queue.offer(new Pipe(대각선,nx+1,ny+1));
				}
				break;
			case 대각선:
				if(ny+1<N && map[nx][ny+1] != 1) {
					queue.offer(new Pipe(가로,nx,ny+1));
				}
				if(nx+1 < N && map[nx+1][ny] != 1) {
					queue.offer(new Pipe(세로,nx+1,ny));
				}
				
				if(ny+1<N && nx+1<N && map[nx][ny+1] != 1 && map[nx+1][ny+1] != 1 && map[nx+1][ny] != 1) { // 오른쪽, 오른쪽 아래, 아래 전부다 비어있음
					queue.offer(new Pipe(대각선,nx+1,ny+1));
				}
				break;

			}

		}
	}

	private static void comb(int n, int k) {

		int[][] B = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			int end = Math.min(i, k);
			for (int j = 0; j <= end; j++) {
				if (j == 0 || i == j)
					B[i][j] = 1;
				else
					B[i][j] = B[i - 1][j - 1] + B[i - 1][j];

			}

		}
		result = B[n][k];
	}

}