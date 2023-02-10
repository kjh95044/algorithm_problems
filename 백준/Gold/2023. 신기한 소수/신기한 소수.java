import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	static int N;
	static int total;

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */
		N = Integer.parseInt(br.readLine());

		/*
		 * 3. 알고리즘 풀기
		 */

		int[] primeNums = { 2, 3, 5, 7 };
		for (int i = 0; i < 4; i++) {
			checkNextIsPrime(primeNums[i]);
		}

		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}

	private static void checkNextIsPrime(int num) {
		// 기저부분
		if (String.valueOf(num).length() == N) {
			if (isPrime(num)) {
				total++;
				sb.append(num + "\n");
			}
			return;
		}

		// 유도부분
		for (int i = 0; i <= 9; i++) {
			int newNum = num * 10 + i;
			if (isPrime(newNum)) {
				checkNextIsPrime(newNum);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}