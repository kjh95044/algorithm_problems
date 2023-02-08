import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[] numbers;
	private static boolean[] isSelected;
	private static int[] inputNums;

	private static boolean isInputNumsNext;
	private static String result;
	private static int total;

	// 순열은 순서가 있고 중복은 없다.

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */
		N = Integer.parseInt(br.readLine());
		inputNums = new int[N];

		String[] split = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			inputNums[i] = Integer.parseInt(split[i]);
		}

		// 마지막 값
		int[] lastNums = new int[N];
		for (int i = 0; i < N; i++) {
			lastNums[i] = N - i;
		}

		// input 값이 마지막 값이면 -1 출력하고 끝낸다.
		if (Arrays.toString(lastNums).equals(Arrays.toString(inputNums))) {
			System.out.println(-1);
			return;
		}

		/*
		 * 3. 알고리즘 풀기
		 */

		// 순열 배워서 순열로 했더니 시간 초과가 떴다.
		/*
		 * 
		 * 뒤에서부터 두개 세개 네개 이런식으로 확인하는데 오름차순이 맞으면 안바꿔도 되고 오름차순이 안되는 시점에서 그 인덱스의 값보다 가장 가까운
		 * 큰값을 해당 위치에 넣고 나머지는 내림차순으로 바꾼다.
		 */

		int[] resultNums = inputNums.clone();
		for (int i = N-2; i >=0; i--) {
			// 뒤에서부터 오름차순이 아니면
			if(inputNums[i] < inputNums[i+1]) {
				int[] temp = Arrays.copyOfRange(inputNums, i, N);
				Arrays.sort(temp);;
				//System.out.println(Arrays.toString(temp));
				for (int j = 0; j < temp.length; j++) {
					int tempVal = 0;
					if(inputNums[i]==temp[j]) {
						tempVal = j;
					}
					if(inputNums[i]<temp[j]) {
						resultNums[i] = temp[j];
						temp[j] = temp[tempVal];
						temp[tempVal] = 10001;
						
						Arrays.sort(temp);
						temp = Arrays.copyOfRange(temp, 0, temp.length-1);
						//System.out.println("여기 : " + Arrays.toString(temp));
						for(int k = i+1; k<N; k++) {
							resultNums[k] = temp[k-i-1];
						}
						break;
					}
				}
				break;
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(resultNums[i] + " ");
		}

		// 순열 시도
//			isSelected = new boolean[N+1];
//			numbers = new int[N];
//			permutation(0);
//			if(result == null) {
//				sb.append(-1);
//			}
//			else {
//				sb.append(result);
//			}
		//
//			/*
//			 * 4. 정답 출력
//			 */
//			sb.append("total : " + total);
		System.out.println(sb);
	}

	private static void permutation(int n) {
		if (n == N) {
			// [1, 2, 3] 형태
			total++;
			if (isInputNumsNext) {
				result = "";
				for (int i = 0; i < N; i++) {
					result += numbers[i] + " ";
				}
				isInputNumsNext = false;
			}

			System.out.println(Arrays.toString(numbers));
			if (Arrays.toString(numbers).equals(Arrays.toString(inputNums))) {
				isInputNumsNext = true;
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				continue;
			}
			numbers[n] = i;
			isSelected[i] = true;
			permutation(n + 1);
			isSelected[i] = false;
		}

	}
}