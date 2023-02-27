import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][] map;

	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		map = new int[101][101];

		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					// 겹치는 부분을 1로 만든다.
					map[i][j] = 1;
				}
			}
		}

		// 알고리즘 시작
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				
				// 1인것들만 확인
				if (map[i][j] == 0) {
					continue;
				}

				int zeroCnt = 0;

				// 흰색 스카프 끝에서는 0을 확인할수 없어서 따로 2로 만들어 주었다.
				if (i == 0 || j == 0 || i == 100 || j == 100) {
					map[i][j] = 2;
				}

				else {
					// 주변에 0이 있으면 zeroCnt ++
					for (int k = 0; k < 4; k++) {
						int nx = i + delta[k][0];
						int ny = j + delta[k][1];

						if (!(nx >= 0 && ny >= 0 && nx < 101 && ny < 101)) {
							continue;
						}

						if (map[nx][ny] == 0) {
							zeroCnt++;
						}
					}
					map[i][j] = zeroCnt + 1;
				}

			}
		}

		int cnt = 0;
		for (int[] sMap : map) {
//			System.out.println(Arrays.toString(sMap));
			for (int n : sMap) {
				if (n >= 1) {
					cnt += n - 1; // 검정색 스카프 안쪽을 확인하기 위해 +1로 해놨기 때문에 -1을 해주었다.
				}
			}
		}
		System.out.println(cnt);
	}

}