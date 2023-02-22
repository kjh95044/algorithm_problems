import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 거리가 있다? 가중치?

public class Solution {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int getDistance(Point p) {
			return (Math.abs(x-p.x) + Math.abs(y-p.y));
		}
		
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}

	static Point home, company;
	static Point[] customers, numbers;
	static int cusNum, map[][];
	static boolean[] isSelected;
	static int result;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <=T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			cusNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int compX = Integer.parseInt(st.nextToken());
			int compY = Integer.parseInt(st.nextToken());
			company = new Point(compX, compY);
			
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			home = new Point(homeX, homeY);


			customers = new Point[cusNum];
			numbers = new Point[cusNum];
			isSelected = new boolean[cusNum];
			result = Integer.MAX_VALUE;
			
			for(int i=0; i<cusNum; i++) {
				int cusX = Integer.parseInt(st.nextToken());
				int cusY = Integer.parseInt(st.nextToken());
				customers[i] = new Point(cusX, cusY);
			}
			
			
//			sb.append(home).append("\n");
//			sb.append(company).append("\n");
//			for (Point cus : customers) {
//				sb.append(cus).append(" ");
//			}
			
//			dfs(0, company, 0);
			permutation(0);
			sb.append(result);
			sb.append("\n");
		}
	

		System.out.println(sb);
	}
	
	private static void permutation(int num) {
		if(num == cusNum) {
			
			int sum = company.getDistance(numbers[0]);
			for (int i = 1; i < numbers.length; i++) {
				sum+= numbers[i-1].getDistance(numbers[i]);
			}
			sum+= numbers[numbers.length-1].getDistance(home);

			result = Math.min(result, sum);
			return;
		}
		
		for(int i=0; i<cusNum; i++) {
			
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i]= true;
			numbers[num] = customers[i];
			permutation(num+1);
			isSelected[i] = false;
		}
	}

//	// 가장 가까운 거리를 찾는다.
//	// 
//	private static void dfs(int num, Point p, int sum) {
//		if(num == cusNum) {
//			sb.append(sum + p.getDistance(home));
//			return;
//		}
//		
//		Point minPoint = null;
//		int minDist = Integer.MAX_VALUE;
//		int index = 0;
//		
//		for(int i = 0; i<cusNum; i++) {
//			if(isSelected[i]) {
//				continue;
//			}
//			
//			Point cus = customers[i];
//			
//			if(cus.getDistance(p) < minDist) {
//				index = i;
//				minPoint = cus;
//				minDist = cus.getDistance(p);
//				minPoint = cus;
//			}
//		}
//
//		isSelected[index] = true;
//		dfs(num+1, minPoint, sum + minDist);
//	}
}