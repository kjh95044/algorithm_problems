import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N, M;
	static StringBuilder result = new StringBuilder();
	static boolean[] dupChcek;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N];
		dupChcek = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		isFoundAnswer = false;
		
		for(int i=0; i<N; i++) {
			dfs(i, new boolean[N], 1);
			if(isFoundAnswer) {
				break;
			}
		}
		
		if(isFoundAnswer) {
			sb.append(1);
		}
		else {
			sb.append(0);
		}
		
		System.out.println(sb);
	}
	
	static boolean isFoundAnswer;
	
	private static void dfs(int current, boolean [] visited, int cnt ) {
		
		if(cnt == 5) {
			isFoundAnswer = true;
			return;
		}
		
		visited[current] = true;
		
		for(Node temp = adjList[current]; temp!=null; temp = temp.next) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex, visited, cnt + 1);
			}
			if(isFoundAnswer) {
				return;
			}
		}
		visited[current] = false;
	}
}