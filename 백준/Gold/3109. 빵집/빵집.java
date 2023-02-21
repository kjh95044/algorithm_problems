import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int r, c;
	static char map[][];
	static int delta[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } }; // 오른쪽 위, 오른쪽, 오른쪽 아래
	static boolean visited[][];
	static int result;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'x') {
					visited[i][j] = true;
				}
			}
		}

		for(int i=0; i<r; i++) {
			flag = false;
			dfs(i, 0);
		}
		

		sb.append(result);
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		
		if (y == c - 1) {
			flag = true;
			result++;
			return;
		}

		visited[x][y] = true;
		
		for (int k = 0; k < 3; k++) {
			int nx = x + delta[k][0];
			int ny = y + delta[k][1];

			if (!(nx >= 0 && nx < r && ny >= 0 && ny < c))
				continue;

			if (!visited[nx][ny] && !flag) {
				dfs(nx, ny);
				//visited[x][y] = false;
			}
		}

	}
}