import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int R;
	static int[][] data;
	static int[][] result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		R = Integer.parseInt(split[2]);

		data = new int[N][M];
		result = new int[N][M];

		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(split[j]);
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case 1:
				operationOne();
				break;
			case 2:
				operationTwo();
				break;
			case 3:
				operationThree();
				break;
			case 4:
				operationFour();
				break;
			case 5:
				operationFive();
				break;
			case 6:
				operationSix();
				break;
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void operationOne() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[N - i - 1][j] = data[i][j];
			}
		}
		data = result;
	}

	private static void operationTwo() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][M - j - 1] = data[i][j];
			}
		}
		data = result;
	}

	private static void operationThree() {
		result = new int[M][N];

		int k = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[j][k] = data[i][j];
			}
			k--;
		}

		int temp = N;
		N = M;
		M = temp;
		data = result;
	}

	private static void operationFour() {

		result = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[M - j - 1][i] = data[i][j];
			}
		}

		int temp = N;
		N = M;
		M = temp;
		data = result;

	}

	// 1->2, 2->3, 3->4, 4->1
	private static void operationFive() {

		int midN = N / 2;
		int midM = M / 2;
		result = new int[N][M];
		// 1->2
		for (int i = 0; i < midN; i++) {
			for (int j = 0; j < midM; j++) {
				result[i][midM + j] = data[i][j];
			}
		}

		// 2->3
		for (int i = 0; i < midN; i++) {
			for (int j = midM; j < M; j++) {
				result[i + midN][j] = data[i][j];
			}
		}

		// 3->4
		for (int i = midN; i < N; i++) {
			for (int j = midM, k = 0; j < M; j++, k++) {
				result[i][k] = data[i][j];
			}
		}

		// 4->1
		for (int i = midN, k = 0; i < N; i++, k++) {
			for (int j = 0; j < midM; j++) {
				result[k][j] = data[i][j];
			}
		}
		data = result;

	}

	// 1->4, 4->3, 3->2, 2->1
	private static void operationSix() {

		int midN = N / 2;
		int midM = M / 2;
		result = new int[N][M];
		// 1->4
		for (int i = 0; i < midN; i++) {
			for (int j = 0; j < midM; j++) {
				result[midN + i][j] = data[i][j];
			}
		}

		// 4->3
		for (int i = midN; i < N; i++) {
			for (int j = 0; j < midM; j++) {
				result[i][j + midM] = data[i][j];
			}
		}

		// 3->2
		for (int i = midN, k = 0; i < N; i++, k++) {
			for (int j = midM; j < M; j++) {
				result[k][j] = data[i][j];
			}
		}

		// 2->1
		for (int i = 0; i < midN; i++) {
			for (int j = midM, k = 0; j < M; j++, k++) {
				result[i][k] = data[i][j];
			}
		}
		data = result;
	}

}