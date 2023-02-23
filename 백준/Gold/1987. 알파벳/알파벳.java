import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x,y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	static int R, C, result, max;
	static char[][] map;
	static List<Character> horse;

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		horse = new ArrayList<>();
		dfs(0,0,0);
		sb.append(result);
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int cnt) {
		if(horse.contains(map[x][y])) {
			result = Math.max(result, cnt);
			return;
		}
		
		
		horse.add(map[x][y]);
		
		for(int i=0; i<4; i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			
			if(!(nx>=0 && ny>=0 && nx<R && ny<C)) {
				continue;
			}
			
			dfs(nx, ny, cnt + 1);
		}
		
		horse.remove((Character)map[x][y]);
		
	}
	
	
}