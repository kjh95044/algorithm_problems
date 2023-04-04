import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int map[][];
	static boolean[][] visited;
	static List<Edge> edgeList = new ArrayList<>();

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	
	static int[] parents;
	
	static void makeSet(int V) {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]); // 패스 압축
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 맵에서 섬 구분
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(new Point(i, j));
				}
			}
		}

		// 테스트용 출력
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 다리 만들기
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) { // 섬이면
					visited[i][j] = true;

					
					for (int d = 0; d < 4; d++) { // 4방탐색 했을때 0이면 그 방향으로 쭉 탐색 -> 새로운 섬 발견시 연결리스트 연결
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
						int bridgeLen = 0;

						if (!(nx >= 0 && ny >= 0 && nx < N && ny < M))
							continue;

						if (map[nx][ny] == 0) {
							while (true) {
								bridgeLen++;

								nx += delta[d][0];
								ny += delta[d][1];

								if (!(nx >= 0 && ny >= 0 && nx < N && ny < M))
									break;
								;

								if (map[nx][ny] != 0) {
									if (bridgeLen >= 2) {
										edgeList.add(new Edge(map[i][j], map[nx][ny], bridgeLen));
									}
									break;
								}
							}
						}

					}

				}
			}
		}
		
//		for (Edge edge : edgeList) {
//			System.out.println(edge);
//		}
//		
		
		Collections.sort(edgeList);

		// mst로 최솟값 구하기
		makeSet(nodeCnt+1);
		
		int result=0, count=0;
		
		for (Edge edge: edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == nodeCnt-1) {
					break;
				}
			}
		}
		
		for (Edge edge: edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == nodeCnt-1) {
					break;
				}
			}
		}

		boolean isConnected = true;
		int past = parents[1];
		
		for (int k = 2; k < parents.length; k++) {
			if(past != parents[k]) {
				isConnected = false;
				break;
			}
		}
		
		if(!isConnected) {
			result = -1;
		}
		
		System.out.println(result);

	}

	static int nodeCnt = 0;
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static void bfs(Point p) {
		nodeCnt += 1;
		map[p.x][p.y] = nodeCnt;
		visited[p.x][p.y] = true;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(p);

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now.x + delta[d][0];
				int ny = now.y + delta[d][1];

				if (!(nx >= 0 && ny >= 0 && nx < N && ny < M))
					continue;

				if (visited[nx][ny] || map[nx][ny] != 1)
					continue;

				visited[nx][ny] = true;
				map[nx][ny] = nodeCnt;
				q.offer(new Point(nx, ny));
			}
		}
	}

}