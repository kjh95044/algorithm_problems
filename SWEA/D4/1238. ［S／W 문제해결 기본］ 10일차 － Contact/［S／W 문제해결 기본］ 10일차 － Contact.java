import java.util.*;
import java.io.*;

public class Solution {

	static StringBuilder sb = new StringBuilder();

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
	}

	static Node[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			adjList = new Node[101];

			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i+=2) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from] = new Node(to, adjList[from]);
			}

//			System.out.println("#"+ test_case);
			bfs(start);
//			System.out.println();
			
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int start) {
		boolean[] visited = new boolean[101];
		HashMap<Integer, Integer> lvMap = new HashMap<>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		visited[start] = true;
		queue.offer(start);
		
		int level = 0;
		int maxLevel = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			level ++;
			maxLevel = Math.max(level, maxLevel);
//			System.out.println("level : " + level);
			
			while (size--> 0) {
				int current = queue.poll();
//				System.out.print(current + " ");
				if(level!=1)
					lvMap.put(level, Math.max(lvMap.getOrDefault(level, 0), current));
					

				for (Node temp = adjList[current]; temp != null; temp = temp.next) {
					
					if (!visited[temp.vertex]) {
						queue.offer(temp.vertex);
						
						visited[temp.vertex] = true;
					}
				}
			}
//			System.out.println();
		}
		
		sb.append(lvMap.get(maxLevel));
	}
}