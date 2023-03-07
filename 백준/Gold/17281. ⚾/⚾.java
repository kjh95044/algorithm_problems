import java.util.*;
import java.io.*;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int[][] playerResult;
	private static int[] numbers = new int[9];
	private static boolean[] isSelected = new boolean[9];;
	static int N;
	static int result;

	static class BaseBall {
		public int out, score;
		public boolean one, two, three;

		void resetBaseForNewInning() {
			baseBall.out = 0;
			baseBall.one = false;
			baseBall.two = false;
			baseBall.three = false;
		}
		
		void play(int cmd) {
			switch (cmd) {
			case 1:
				if (three) {
					three = false;
					score++;
				}
				if (two) {
					two = false;
					three = true;
				}
				if (one) {
					one = false;
					two = true;
				}
				one = true;
				break;
			case 2:
				if (three) {
					three = false;
					score++;
				}
				if (two) {
					two = false;
					score++;
				}
				if (one) {
					one = false;
					three = true;
				}
				two = true;
				break;
			case 3:
				if (three) {
					three = false;
					score++;
				}
				if (two) {
					two = false;
					score++;
				}
				if (one) {
					one = false;
					score++;
				}
				three = true;
				break;
			case 4:
				if (three) {
					three = false;
					score++;
				}
				if (two) {
					two = false;
					score++;
				}
				if (one) {
					one = false;
					score++;
				}
				score++;
				break;
			case 0:
				out++;
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		playerResult = new int[N][9];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				playerResult[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 타순을 먼저 정하고
		// 각 이닝을 돌려본다.
		// 그중 최대 득점을 구해보자.

		permutation(0);

		sb.append(result);
		System.out.println(sb);
	}

	static private BaseBall baseBall;

	private static void permutation(int cnt) {
		if (cnt == 8) {
			int[] newNumbers = new int[9];
			baseBall = new BaseBall();
			for (int i = 0; i < 3; i++) {
				newNumbers[i] = numbers[i];
			}
			newNumbers[3] = 0;
			for (int i = 4; i < 9; i++) {
				newNumbers[i] = numbers[i - 1];
			}
//			sb.append(Arrays.toString(newNumbers)).append("\n");

			// 야구 게임 시작

			int current = 0;
			for (int i = 0; i < N; i++) {
				while(baseBall.out != 3) {
					baseBall.play(playerResult[i][newNumbers[current]]);
					current = (current+1) % 9;
				}
				baseBall.resetBaseForNewInning();
			}

			result = Math.max(result, baseBall.score);

			return;
		}

		for (int i = 1; i < 9; i++) {
			if (isSelected[i]) {
				continue;
			}
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}