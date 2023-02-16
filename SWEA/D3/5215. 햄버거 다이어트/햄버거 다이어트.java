import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	static int ingredientCnt;
	static int limitKcal;
	static int[][] info;
	static int maxScore;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("res/17478_input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredientCnt = Integer.parseInt(st.nextToken());
			limitKcal = Integer.parseInt(st.nextToken());
			info = new int[ingredientCnt][2];
			maxScore = 0;
			isSelected = new boolean [ingredientCnt];

			
			for (int i = 0; i < ingredientCnt; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				info[i][0] = score;
				info[i][1] = kcal;
			}
			
			subSet(0);
			sb.append(maxScore).append("\n");
		}

		System.out.println(sb);
	}

	private static void subSet(int index) {
		if (index == ingredientCnt) {  // 더 이상 고려할 원소가 없다면 부분집합의 구성이 완성

			int sumScore = 0;  // 점수의 합
			int sumKcal = 0;  // 칼로리의 합

			for (int i = 0; i < ingredientCnt; i++) {
				if (isSelected[i]) {
					sumScore += info[i][0];
					sumKcal += info[i][1];
				}
			}

			// 만약 제한 칼로리 이하이면
			if (sumKcal <= limitKcal) {

				// 맛에 대한 점수 최대값 갱신
				if (sumScore > maxScore) {
					maxScore = sumScore;
				}
			}
			return;
		}


		// 원소 선택
		isSelected[index] = true;
		subSet(index + 1);

		// 원소 미선택
		isSelected[index] = false;
		subSet(index + 1);

	}
}