import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int danjiNum = 1;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int[] answer = new int[N * N + 1]; // N * N 크기 + 1

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(N, i, j); // 단지의 크기를 반환받음
                    answer[danjiNum] = count; // 단지 번호에 따라 크기를 기록
                    danjiNum++;
                }
            }
        }

        System.out.println(danjiNum - 1); // 총 단지 수 출력

        int[] result = Arrays.copyOfRange(answer, 1, danjiNum);
        Arrays.sort(result); // 단지 크기 정렬

        for (int size : result) {
            System.out.println(size); // 각 단지 크기 출력
        }
    }

    static int bfs(int N, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        map[x][y] = danjiNum;
        visited[x][y] = true;

        int count = 1; // 단지 내 집의 수

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = temp[0] + dx[d];
                int ny = temp[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] != 1) continue;

                queue.add(new int[]{nx, ny});
                map[nx][ny] = danjiNum;
                visited[nx][ny] = true;
                count++;
            }
        }
        return count;
    }
}