import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[][] city;
	
	static List<Point> chicken;
	static List<Point> home;

	static int[] numbers;
	static int chickenDistance = Integer.MAX_VALUE;
	 

	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]); // 도시 크기
		M = Integer.parseInt(split[1]); // 최대 치킨집 개수
		city = new int[N+1][N+1];

		chicken = new ArrayList<>();
		home = new ArrayList<>();
		numbers = new int[M];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int input = Integer.parseInt(st.nextToken());
				city[i][j] = input;
				if(input == 2) {
					chicken.add(new Point(i,j));
				}
				else if(input == 1) {
					home.add(new Point(i,j));
				}
			}
		}
		
		
		
		/*
			풀이
			
			2의 위치 저장하고 N개 치킨집 중에 M개 골라서 2의 위치 다시 저장 (nCm)
			저장된 2의 위치와 1의 위치 간의 최단거리를 구한 합이 도시의 치킨거리
			
			nCm개중에 최솟값을 구하자.
		 */
		
		combination(0,0);
		
		sb.append(chickenDistance);
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		
		if(cnt==M) {
			List<Point> newChicken = new ArrayList<>();
			
			for(int index : numbers) {
				newChicken.add(chicken.get(index));
			}
			
			// 최단거리 구하기
			updateChickendistance(newChicken);
			
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static void updateChickendistance(List<Point> chicken) {
		// 치킨거리 합
		int cdSum = 0;
		for(Point hp : home) {
			// 치킨 거리중 가장 짧은게 치킨거리가 된다.
			int cdMin = Integer.MAX_VALUE;
			for(Point cp : chicken) {
				int cd = Math.abs(hp.x - cp.x) + Math.abs(hp.y - cp.y);
				cdMin = Math.min(cdMin, cd);
			}
			cdSum+= cdMin;
		}
		// 도시 치킨 거리
		chickenDistance = Math.min(chickenDistance, cdSum);
	}
}