import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int map[][];
	static int[][] delta= {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	
	public static void main(String[] args) throws IOException {
		int cnt = 0;
		while(true) {
			cnt++;
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			map = new int[N][N];
			sb.append("Problem ").append(cnt).append(": ");
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append(dijkstra());
			sb.append("\n");
		}
	
		
		System.out.println(sb);
	}
	
	private static int dijkstra() {
		final int INF = Integer.MAX_VALUE;
		int[][] minTime = new int[N][N]; // 출발정점에서 자신까지 이르는 최소 복구시간
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]); // 출발지에서 자신까지의 최소 비용 기반으로 정렬
			}
		}); // r,c, 출발지에서 자신까지의 최소 비용

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}

		minTime[0][0] = map[0][0];
		pq.offer(new int[] { 0, 0, minTime[0][0] });

		int[] cur = null;
		int x, y, minCost;
		while (true) {

			// step1
			cur = pq.poll();
			x = cur[0];
			y = cur[1];
			minCost = cur[2];

			if (visited[x][y])
				continue; // 큐에 남아있는 잔재
			visited[x][y] = true;
			if (x == N - 1 && y == N - 1)
				return minCost; // 도착지에 오면 끝내기

			// step2
			int nx = 0, ny = 0;
			for (int d = 0; d < 4; d++) {
				nx = x + delta[d][0];
				ny = y + delta[d][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]
						&& minTime[nx][ny] > minCost + map[nx][ny]) {
					
					minTime[nx][ny] = minCost + map[nx][ny];
					pq.offer(new int[] { nx, ny, minTime[nx][ny] });
				}
			}

		}

	}
}