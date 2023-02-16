import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	static int N;
	static int R;
	static int[][] synergyTable;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("res/17478_input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			synergyTable = new int[N][N];
			numbers = new int[N / 2];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergyTable[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(0, 0);
			sb.append(min).append("\n");
		}
		/*
		 * 3. 알고리즘 풀기
		 */

		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		if (cnt == R) {
			int[] listA = new int[R];
			int[] listB = new int[R];

			boolean[] isSelected = new boolean[N];
			int indexA = 0;
			for (int i = 0; i < R; i++) {
				listA[indexA++] = numbers[i];
				isSelected[numbers[i]] = true;
			}

			int indexB = 0;
			for (int i = 0; i < N; i++) {
				if (!isSelected[i]) {
					listB[indexB++] = i;
				}
			}

			int A = 0;
			int B = 0;

			for (int i = 0; i < R - 1; i++) {
				for (int j = i; j < R; j++) {
					A += synergyTable[listA[i]][listA[j]] + synergyTable[listA[j]][listA[i]];
					B += synergyTable[listB[i]][listB[j]] + synergyTable[listB[j]][listB[i]];
				}
			}

			int abs = Math.abs(A - B);
			if (abs < min) {
				min = abs;
			}
			return;

		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}