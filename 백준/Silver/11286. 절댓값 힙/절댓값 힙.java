import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) - Math.abs(o2) == 0) {
					return o1 - o2;
				}
				else {
					return Math.abs(o1) - Math.abs(o2);
				}
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input!=0) {
				queue.offer(input);
			}
			else {
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}
				
			}
		}

		/*
		 * 3. 알고리즘 풀기
		 */

		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
}