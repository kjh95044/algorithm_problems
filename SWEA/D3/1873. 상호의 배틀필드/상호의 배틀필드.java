import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int H, W, N;
	static char[][] map;
	static char tankDirection;
	static Point tankLocation;
	static int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 우 좌 하 상
	static HashMap<Character, Integer> direction;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		direction = new HashMap<>();
		direction.put('>', 0);
		direction.put('<', 1);
		direction.put('v', 2);
		direction.put('^', 3);

		/*
		 * 문자 의미 . 평지(전차가 들어갈 수 있다.) 벽돌로 만들어진 벽 # 강철로 만들어진 벽 - 물(전차는 들어갈 수 없다.) ^ 위쪽을
		 * 바라보는 전차(아래는 평지이다.) v 아래쪽을 바라보는 전차(아래는 평지이다.) < 왼쪽을 바라보는 전차(아래는 평지이다.) > 오른쪽을
		 * 바라보는 전차(아래는 평지이다.) 다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.
		 * 
		 * 문자 동작 U Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다. D Down : 전차가
		 * 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다. L Left : 전차가 바라보는 방향을 왼쪽으로
		 * 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다. R Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의
		 * 칸이 평지라면 그 칸으로 이동한다. S Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
		 * 
		 * 전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다. 전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽
		 * 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다. 만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이
		 * 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다. 강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다. 게임 맵
		 * 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다. 초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 모든 입력을 처리하고
		 * 나면 게임 맵의 상태가 어떻게 되는지 구하는 프로그램을 작성하라.
		 */

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String components = br.readLine();
				for (int j = 0; j < W; j++) {
					char comp = components.charAt(j);
					map[i][j] = comp;
					if (comp == '<' || comp == '>' || comp == 'v' || comp == '^') {
						tankLocation = new Point(i, j);
						tankDirection = comp;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			char cmd[] = br.readLine().toCharArray();
			for (char c : cmd) {
				switch (c) {
				case 'U':
					tankDirection = '^';
					move();
					break;
				case 'D':
					tankDirection = 'v';
					move();
					break;
				case 'L':
					tankDirection = '<';
					move();
					break;
				case 'R':
					tankDirection = '>';
					move();
					break;
				case 'S':
					shoot();
					break;
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}


		System.out.println(sb);
	}

	private static void shoot() {
		int x = tankLocation.x;
		int y = tankLocation.y;
		int nx = x;
		int ny = y;
		while (true) {
			nx = nx + delta[direction.get(tankDirection)][0];
			ny = ny + delta[direction.get(tankDirection)][1];

			if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
				char comp = map[nx][ny];
				if (comp == '*') {
					map[nx][ny] = '.';
					break;
				} else if (comp == '#') {
					break;
				}
			}
			else {
				break;
			}
		}
	}

	private static void move() {
		int x = tankLocation.x;
		int y = tankLocation.y;
		
		map[x][y] = tankDirection;
		
		int nx = x + delta[direction.get(tankDirection)][0];
		int ny = y + delta[direction.get(tankDirection)][1];

		if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
			if (map[nx][ny] == '.') {
				map[x][y] = '.';
				map[nx][ny] = tankDirection;
				tankLocation = new Point(nx,ny);
			}
		}
	}
}