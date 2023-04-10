import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,targetTime;
	static char[][] map;
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}}; 
	
	public static void main(String[] args) throws IOException {
		// 1. 폭탄은 3초가 지난 후에 폭발
		// 2. 인접한 네칸도 파괴 (인접한 네칸에 폭탄이 있더라도 연쇄 폭발은 일어나지 않는다.)
		// 3. 모든 칸에 폭탄 채운다.
		// 4. 3초가 되면 3초전에 설치한 폭탄이 터진다.

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		targetTime = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		char[][] map2 = new char[N][M];
		
		if(targetTime%2 == 0) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					sb.append("O");
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			return;
		}
		

		
		Queue<Point> q = new ArrayDeque<>();
		
		for (int n = 0; n < N; n++) {
			String input = in.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = input.charAt(m);
				map2[n][m] = 'O';
				
				if(map[n][m] == 'O') {
					q.offer(new Point(n,m));
				}
			}
		}
		
		if(targetTime==1) {
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					sb.append(map[n][m]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}
		
		while(!q.isEmpty()) { // bomb
			Point now = q.poll();
			map2[now.x][now.y] = '.';

			for (int d = 0; d < 4; d++) {
				int nx = now.x + delta[d][0];
				int ny = now.y + delta[d][1];

				if (!(nx >= 0 && ny >= 0 && nx < N && ny < M))
					continue;
				map2[nx][ny] = '.';
			}
			
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {

				if(map2[n][m] == 'O') {
					q.offer(new Point(n,m));
				}
			}
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				map[n][m] = 'O';
			}
		}
		
		while(!q.isEmpty()) { // bomb
			Point now = q.poll();
			map[now.x][now.y] = '.';

			for (int d = 0; d < 4; d++) {
				int nx = now.x + delta[d][0];
				int ny = now.y + delta[d][1];

				if (!(nx >= 0 && ny >= 0 && nx < N && ny < M))
					continue;
				map[nx][ny] = '.';
			}
			
		}
		
		
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(targetTime%4 == 1) {
					sb.append(map[n][m]);
				}
				else {
					sb.append(map2[n][m]);
				}
			}
			sb.append("\n");
		}

		
//		sb.append("\n");
//		
//		for (int n = 0; n < N; n++) {
//			for (int m = 0; m < M; m++) {
//				sb.append(map2[n][m]);
//				
//			}
//			sb.append("\n");
//		}
		System.out.println(sb);
		
		
		
	}
}