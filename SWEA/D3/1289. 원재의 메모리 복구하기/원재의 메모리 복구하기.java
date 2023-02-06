import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("res/17478_input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String input = in.readLine();
			/*
			 * 3. 알고리즘 풀기
			 */

			int answer = 0;

			// 첫번째 비트가 1이면 이미 한번 수정한 것이므로 수정횟수 증가
			if (input.charAt(0) == '1') {
				answer++;
			}

			for (int i = 0; i < input.length() - 1; i++) {
				if (input.charAt(i) != input.charAt(i + 1)) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}

		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
}