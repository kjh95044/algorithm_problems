import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int[][] data;
	private static int N;
	private static int totalCnt;
	private static int maxCnt;
	private static int maxRoom;

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("res/17478_input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		/*
		 * 2. 입력파일 객체화
		 */
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			N = Integer.parseInt(br.readLine());
			data = new int[N][N];
			totalCnt = 0;
			maxCnt = 0;
			maxRoom = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			/*
			 * 3. 알고리즘 풀기
			 */

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					totalCnt= 0;
					dfs(i,j,0);
					if(totalCnt>maxCnt) {
						maxCnt = totalCnt;
						maxRoom = data[i][j];
					}
					else if(totalCnt == maxCnt) {
						maxRoom = Math.min(data[i][j], maxRoom);
					}
				}
			}
			
			sb.append(maxRoom).append(" ").append(maxCnt+1).append("\n");
		}
		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}

	static int[][] delta = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited;

	private static void dfs(int x, int y, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];

			if (!(nx >= 0 && ny >= 0 && nx < N && ny < N)) {
				continue;
			}
			
			if(data[nx][ny] == (data[x][y] + 1)) {
				totalCnt++;
				dfs(nx,ny,cnt++);
			}
		}
	}

}