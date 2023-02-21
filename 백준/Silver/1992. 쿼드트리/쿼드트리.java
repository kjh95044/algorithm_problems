import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int)(input.charAt(j)-'0');
			}
		}
		
		cut(0,0,N);
		System.out.println(sb);
	}

	private static void cut(int r, int c, int size) {
		int first = map[r][c];
		boolean flag = false;
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(first != map[i][j]) {
					flag = true;
				}
			}
		}
		
		if(!flag) {
			sb.append(first);
			return;
		}
		
		int half = size/2;
		sb.append("(");
		cut(r, c, half);
		cut(r, c + half, half);
		cut(r+half, c, half);
		cut(r+half, c+half, half);
		sb.append(")");
	}
}