import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, result;
	static int[][] map;
	static final int 가로 = 0, 세로 = 1, 대각선 = 2;

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

		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		bfs();
		dp();

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

	private static void dp() {
		int[][][] D = new int[N+1][N+1][3];
		D[1][2][가로] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=3; j<=N; j++) {
				if(map[i][j] == 1) {
					continue;
				}
				
				// 현재 위치에 가로 파이프를 놓을수 있는 경우의 수는 
				// 이전 파이프를 가로로 놓은 경우와 대각선으로 놓은 경우의 합이다.
				D[i][j][가로] = D[i][j-1][가로] + D[i][j-1][대각선];
				// 맨 윗줄의 경우는 가로 파이프만 놓을수 있다.
				if(i==1) {
					continue;
				}
				
				D[i][j][세로] = D[i-1][j][세로] + D[i-1][j][대각선];
				if(map[i-1][j] == 1 || map[i][j-1]==1) {
					continue;
				}
				
				D[i][j][대각선] = D[i-1][j-1][가로] + D[i-1][j-1][대각선] + D[i-1][j-1][세로];
			}
			
		}
		result = D[N][N][가로] + D[N][N][세로] + D[N][N][대각선];
	}

}