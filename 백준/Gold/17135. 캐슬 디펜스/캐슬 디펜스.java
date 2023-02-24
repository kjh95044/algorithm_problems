import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/17135
public class Main {

	private static int N;  // 격자판 행의 수
	private static int M;  // 격자판 열의 수
	private static int D;  // 궁수의 공격 거리 제한
	private static List<Enemy> enemies;  // 적들의 정보 저장
	private static int[] numbers;  // 궁수가 위치할 열 인덱스 번호를 저장하는 배열
	private static int max;  // 제거할 수 있는 적의 최대 수

	// 적
	private static class Enemy implements Comparable<Enemy> {

		public int x;  // 행
		public int y;  // 열
		public int damage;  // 화살 맞은 횟수

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Enemy o) {
			// 열 기준 오름차순 정렬 (왼쪽 적부터 제거해야 하므로)
			return this.y - o.y;
		}

		// 디버깅용
		@Override
		public String toString() {
			return "Enemy [x=" + x + ", y=" + y + ", damage=" + damage + "]";
		}

	}

	// 궁수
	private static class Archer {

		public int x;  // 행
		public int y;  // 열

		public Archer(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// 디버깅용
		@Override
		public String toString() {
			return "Archer [x=" + x + ", y=" + y + "]";
		}
	}

	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		//System.setIn(new FileInputStream("res/17135_input1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 1. 입력 파일 객체화
		 */
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		D = Integer.parseInt(split[2]);

		// 적들의 정보 저장
		enemies = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				if (split[j].equals("1")) {
					enemies.add(new Enemy(i, j));
				}
			}
		}

		// 초기화
		numbers = new int[3];  // 문제에서 궁수 3명으로 고정
		max = 0;

		/**
		 * 2. 알고리즘 풀기
		 */
		comb(0, 0);

		/**
		 * 3. 정답 출력
		 */
		sb.append(max);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {

		// 기저 조건 (종료 조건)
		if (cnt == 3) {  // 궁수 3명 위치 선정 완료!

			// 적들의 정보 백업
			List<Enemy> temp = new ArrayList<>();
			for (Enemy e : enemies) {
				temp.add(new Enemy(e.x, e.y));
			}

			// (디버그용)
			//System.out.println("백업정보: " + temp);

			// (디버그용)
			//System.out.println("경우의 수: " + Arrays.toString(numbers) + " / D: " + D);

			// 궁수 3명 생성하고 위치 저장
			List<Archer> archers = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				archers.add(new Archer(N, numbers[i]));
			}

			// 제거한 적들의 수
			int killCount = 0;

			do {
				// 궁수와 가까운 거리의 적을 찾아 제거하기
				for (Archer a : archers) {

					// 궁수와 가장 가까운 적을 찾는다.
					for (int i = 1; i <= D; i++) {  // 사격거리를 1부터 1씩 늘리면서 탐색

						// 전체 적을 순회하면서 사격거리에 들어오는 모든 적들을 리스트에 담기
						List<Enemy> targets = new ArrayList<>();
						for (Enemy e : enemies) {

							// 적과 궁수 간의 거리 구하기
							int dist = Math.abs(e.x - a.x) + Math.abs(e.y - a.y);
							if (dist == i) {
								targets.add(e);
							}
						}

						// 가까운 적을 발견하면
						if (!targets.isEmpty()) {

							// 가장 왼쪽 적부터 제거하기 위해 정렬
							Collections.sort(targets);

							// 가장 가까운 적에게 데미지를 준다. (바로 제거하지 않는다!)
							targets.get(0).damage++;
							break;  // 빠져나온다.
						}
					}
				}

				// 적들을 순회하면서 제거 혹은 이동 수행
				for (int i = enemies.size() - 1; i >= 0; i--) {  // 제거되는 적이 있기 때문에 뒤에서 탐색

					// 적 하나를 가져온다.
					Enemy e = enemies.get(i);

					// 데미지를 입은 적은 바로 제거
					if (e.damage > 0) {
						enemies.remove(e);
						killCount++;
						continue;
					}

					// 해당 적을 한 칸 아래로 이동
					e.x += 1;

					// 만약 적이 격자판 밖으로 나가면
					if (e.x >= N) {

						// 제거
						enemies.remove(e);
					}
				}

				// (디버그용)
				/*int[][] data = new int[N][M];
				for (Enemy e : enemies) {
					data[e.x][e.y] = 1;
				}
				for (int i = 0; i < N; i++) {
					System.out.println(Arrays.toString(data[i]));
				}
				System.out.println("킬 수: " + killCount);
				System.out.println();*/

			} while (!enemies.isEmpty());

			// 최댓값 갱신
			if (killCount > max) {
				max = killCount;
			}

			// 백업했던 적들의 정보 복원
			enemies = new ArrayList<>();
			for (Enemy e : temp) {
				enemies.add(e);
			}

			// (디버그용)
			//System.out.println("복원정보: " + enemies);
			return;
		}

		// start 부터 처리 시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for (int i = start; i < M; i++) {  // 선택지 (격자판 열의 수 중 궁수가 위치할 세 군데 선정)

			// start 위치부터 처리했으므로 중복체크 필요없음!!
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = i;

			// 다음 수 뽑으러 가기
			comb(cnt + 1, i + 1);
		}
	}
}