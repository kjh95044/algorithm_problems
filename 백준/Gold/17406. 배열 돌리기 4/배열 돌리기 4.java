import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int K;
	static int[][] data;
	static boolean[] isSelected;
	static int[] numbers;
	static int[][] rcsArray;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		isSelected = new boolean[K];
		numbers = new int[K];
		
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rcsArray = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rcsArray[i] = new int[]{r,c,s};
		}
		
		permutation(0);
		
		sb.append(min).append("\n");
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		
		if(cnt == K) {
			int[][] temp = copy(data);
			for(int index : numbers) {
				int r = rcsArray[index][0];
				int c = rcsArray[index][1];
				int s = rcsArray[index][2];
				rotate(r-s-1, c-s-1, r+s, c+s);
			}
			updateMin();
			data = copy(temp);
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			isSelected[i] = true;
			numbers[cnt] = i;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static int[][] copy(int [][] original){
		int[][] temp = new int[original.length][original[0].length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = original[i][j];
			}
		}
		
		return temp;
	}


	
	private static void updateMin() {
		for (int i = 0; i < data.length; i++) {
			int sum = 0;
			for (int j = 0; j < data[0].length; j++) {
				sum+=data[i][j];
			}
			min = Math.min(sum, min);
		}
	}

	private static void rotate(int x, int y, int n, int m) {
		int rectCount = Math.min(n-x, m-y) / 2;

		for (int j = 0; j < rectCount; j++) {
			int startX = x + j;
			int startY = y + j;

			int endX = n - 1 - j;
			int endY = m - 1 - j;

			int temp = data[startX][startY];
			
			// 좌변: 아래에서 위쪽으로 이동
			for (int i = startX; i < endX; i++) {
				data[i][startY] = data[i + 1][startY];
			}
			
			// 아랫변: 오른쪽에서 왼쪽으로 이동
			for (int i = startY; i < endY; i++) {
				data[endX][i] = data[endX][i + 1];
			}
			
			// 우변: 위에서 아래로 이동
			for (int i = endX; i > startX; i--) {
				data[i][endY] = data[i - 1][endY];
			}

			// 윗변: 왼쪽에서 오른쪽 이동
			for (int i = endY; i > startY; i--) {
				data[startX][i] = data[startX][i - 1];
			}

			data[startX][startY + 1] = temp;

		}
		
//		System.out.println();
//		for (int i = 0; i < data.length; i++) {
//			for (int k = 0; k < data[0].length; k++) {
//				System.out.print(data[i][k] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

	}
}