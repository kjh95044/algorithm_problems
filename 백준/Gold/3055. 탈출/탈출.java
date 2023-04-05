import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N,M, result;
	static char[][] map;
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visitedWater;
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Point S = null;
		Point D = null;
		
		map = new char[N][M];
		
		// . 빈공간
		// * 물이 차있는 지역
		// X 돌
		// D 비버굴
		// S 고슴도치 위치
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'S') {
					S = new Point(i,j);
					map[i][j] = '.';
				}
				if(map[i][j] == 'D') {
					D = new Point(i,j);
				}
			}
		}
		
		// 물은 4방향으로 확장된다.
		// 물, 고슴도치는 돌 통과 불가능
		// 고슴도치는 물 차있는곳으로 갈수 없고, 물은 비버의 소굴로 이동 불가능
		// 고슴도치는 물이 찰 예정인 칸으로 이동 할수 없다 -> 물먼저 확장하면 될듯!
		
		boolean isEscaped = false;
		
		boolean[][] visited = new boolean[N][M];
		
		Queue<Point> q = new ArrayDeque<>();
		q.offer(S);
		visited[S.x][S.y] = true;
		
		while(!q.isEmpty() && !isEscaped) {
			// 물 확장

			visitedWater = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == '*' && !visitedWater[i][j]) {
						expandWater(i, j);
					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			int size = q.size();
			result ++;
			while(size-->0 && !isEscaped) {
				
				// 고슴도치 이동
				Point cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nx = cur.x + delta[d][0];
					int ny = cur.y + delta[d][1];
					
					if(!(nx>=0&&ny>=0&&nx<N&&ny<M)) continue;
					
					if(map[nx][ny] == 'D') {
						isEscaped = true;
						break;
					}
					
					if(visited[nx][ny] || map[nx][ny]!='.') {
						continue;
					}
					
					
					visited[nx][ny] = true;
					q.offer(new Point(nx,ny));
					
				}
			}
			
		}
		
		// 비버가 더이상 움직일수 없는데, 비버 굴에 도착 못하면 "KAKTUS" 출력
		if(!isEscaped) {
			sb.append("KAKTUS");
		}
		else {
			sb.append(result);
		}
		
		System.out.println(sb);
	}
	
	private static void expandWater(int x, int y) {
		visitedWater[x][y] = true;
		for(int d=0; d<4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			
			if(!(nx>=0&&ny>=0&&nx<N&&ny<M)) continue;
			if(visitedWater[nx][ny] || map[nx][ny]!='.') {
				continue;
			}
			
			map[nx][ny] = '*';
			visitedWater[nx][ny] = true;
			
		}
	}
}