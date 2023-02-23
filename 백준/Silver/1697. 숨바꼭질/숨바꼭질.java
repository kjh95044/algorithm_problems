import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	private static class Node {
		int v;
		int depth;
		
		public Node(int v, int depth) {
			super();
			this.v = v;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int subin = Integer.parseInt(split[0]);
		int littleSubin = Integer.parseInt(split[1]);

		System.out.println(bfs(subin, littleSubin));
	}

	private static int bfs(int N, int K) {
		
		Queue<Node> queue = new ArrayDeque<Node>();
		boolean isVisited[] = new boolean[100001];
		
		queue.offer(new Node(N, 0));
		isVisited[N] = true;
		
		int time = 0;
		while (!queue.isEmpty()) {
			time++;
			
			int size = queue.size();
			
			while(--size >=0) {
				Node curNode = queue.poll();
				
				if (curNode.v == K) {
					return curNode.depth;
				}
				
				Node[] nodes = new Node[3];
				nodes[0] = new Node(curNode.v - 1, time);
				nodes[1] = new Node(curNode.v + 1, time);
				nodes[2] = new Node(2 * curNode.v , time);
				
				for(int i=0; i<3; i++) {
					if(0<= nodes[i].v && nodes[i].v <= 100000 && !isVisited[nodes[i].v]) {
						queue.offer(nodes[i]);
						isVisited[nodes[i].v] = true;
					}
				}
			}
		}
		return -1;
	}
}