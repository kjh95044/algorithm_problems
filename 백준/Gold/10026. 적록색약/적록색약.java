import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	static boolean[][] visited;

	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt ++;
					dfs(i, j);
				}
			}
		}
		
		
		sb.append(cnt).append(" ");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') {
					map[i][j] = 'G';
				}
//				sb.append(map[i][j]);
			}
//			sb.append("\n");
		}

		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt ++;
					dfs(i, j);
				}
			}
		}
		sb.append(cnt);

		System.out.println(sb);

	}

	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, {-1, 0}};

	private static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		for (int k = 0; k < 4; k++) {
			int nx = x + delta[k][0];
			int ny = y + delta[k][1];

			if (!(nx >= 0 && ny >= 0 && nx < N && ny < N)) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			
			if (map[x][y] == map[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

}