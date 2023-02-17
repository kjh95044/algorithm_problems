import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.Future;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		/*
		 *  1. 입력 파일 읽어들이기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int L = Integer.parseInt(split[1]);

		int[] fruits = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);
		/*
		 * 3. 알고리즘 풀기
		 */
		
		for(int h : fruits) {
			if(L>= h) {
				L++;
			}
			else {
				break;
			}
		}

		sb.append(L);
		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
}