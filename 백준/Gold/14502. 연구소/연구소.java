import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M, max;
	static int[][] map;
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 무작정 0인곳에 벽을 3개 세워본다.
		// 안전 구역의 최소값을 출력한다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		
		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if(cnt == 3) {
			int safeCnt = bfs();
			max = Math.max(max, safeCnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
				
				
			}
		}
		
	}

	static boolean[][] visited;
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	
	private static int bfs() {
		int newMap[][] = new int[N][M];
		visited = new boolean[N][M];
		Queue<Point> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j]; // 복사
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && newMap[i][j] == 2) {
					q.offer(new Point(i,j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Point now = q.poll();
						for(int d= 0; d<4; d++) {
							int nx = now.x + delta[d][0];
							int ny = now.y + delta[d][1];
							
							if(!(nx>=0 && ny>=0 && nx<N && ny<M)) continue;
							
							if(visited[nx][ny] || newMap[nx][ny] == 1) continue;
							
							newMap[nx][ny] = 2;
							visited[nx][ny] = true;
							q.offer(new Point(nx,ny));
						}
					}
				}
			}
		}
		
		int safeAreaCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(newMap[i][j]==0) {
					safeAreaCnt++;
				}
			}
		}
		
		
		return safeAreaCnt;
	}
}