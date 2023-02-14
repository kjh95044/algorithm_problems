import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	String detail;
	int left;
	int right;

	public Node(String detail, int left, int right) {
		super();
		this.detail = detail;
		this.left = left;
		this.right = right;
	}

	public Node() {
	}
}

public class Solution {

	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		/*
		 * 1. 입력 파일 읽어들이기
		 */
		// System.setIn(new FileInputStream("res/17478_input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 2. 입력파일 객체화
		 */

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append(" ");

			List<Node> nodes = new ArrayList<Node>();
			nodes.add(0, new Node()); // 0번째에는 더미 노드 넣어둠
			// node의 인덱스가 노드 번호

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Integer.parseInt(st.nextToken()); // index를 노드 번호로 쓸 것이기 떄문에 버림

				String detail = st.nextToken();
				int left = 0;
				int right = 0;

				if (st.hasMoreTokens()) { // 없으면 0
					left = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) { // 없으면 0
					right = Integer.parseInt(st.nextToken());
				}
				Node rootNode = new Node(detail, left, right);
				nodes.add(rootNode);
			}

			/*
			 * 3. 알고리즘 풀기
			 */

			Queue<Node> queue = new ArrayDeque<>();
			queue.offer(nodes.get(1)); // 루트 노드 삽입
			boolean isFound = false;
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(node.detail.equals("+")||
						node.detail.equals("-")||
						node.detail.equals("*")||
						node.detail.equals("/")) {
					if(node.left == 0 || node.right == 0) {
						sb.append(0).append("\n");
						isFound = true;
						break;
					}
					
				}
				else {
					if(node.left != 0 || node.right != 0) {
						sb.append(0).append("\n");
						isFound = true;
						break;
					}
				}
				
				if(node.left != 0) {
					queue.offer(nodes.get(node.left));
				}
				if(node.right != 0) {
					queue.offer(nodes.get(node.right));
				}
			}
			
			if(!isFound) {
				sb.append(1).append("\n");
			}
		}
		/*
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
}