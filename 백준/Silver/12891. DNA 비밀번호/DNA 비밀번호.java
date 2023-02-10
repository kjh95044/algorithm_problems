import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int[] ACGTCnt;
	private static int[] ACGT;
	private static int result;
	
	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */
		String[] split = br.readLine().split(" ");
		int S = Integer.parseInt(split[0]);
		int P = Integer.parseInt(split[1]);
		String input = br.readLine();
		split = br.readLine().split(" ");
		ACGT = new int[4];
		ACGTCnt = new int[4];

		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(split[i]);
		}

		/*
		 * 3. 알고리즘 풀기
		 */

		// ACGT의 갯수를 구해놓고, 갯수가 이상 없는지 확인하고
		// 갯수에 해당하는건 고정 순서는 바꾸기 가능
		// 숫자 이상이면 생각해보자~! ㅋㅋ


		// 첫 P string

		for (char c : input.substring(0, P).toCharArray()) {
			increaseACGTCnt(c);
		}
		checkIsPassword();
		
		for(int i = 0; i<S-P; i++) {
			decreaseACGTCnt(input.charAt(i));
			increaseACGTCnt(input.charAt(i+P));
			checkIsPassword();
		}

		sb.append(result);
		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
	
	private static void checkIsPassword() {
		int checkCnt = 0;
		for (int i = 0; i < 4; i++) {
			if(ACGT[i]<=ACGTCnt[i]) {
				checkCnt++;
			}
		}
		
		if(checkCnt ==4) {
			result++;
		}
	}

	static void increaseACGTCnt(char c) {
		switch (c) {
		case 'A':
			ACGTCnt[0]++;
			break;
		case 'C':
			ACGTCnt[1]++;
			break;
		case 'G':
			ACGTCnt[2]++;
			break;
		case 'T':
			ACGTCnt[3]++;
			break;
		}
	}
	
	static void decreaseACGTCnt(char c) {
		switch (c) {
		case 'A':
			ACGTCnt[0]--;
			break;
		case 'C':
			ACGTCnt[1]--;
			break;
		case 'G':
			ACGTCnt[2]--;
			break;
		case 'T':
			ACGTCnt[3]--;
			break;
		}
	}
	
	
}