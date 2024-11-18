import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxSum = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;

    // 상, 하, 좌, 우
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visited[y][x] = true;
                findMaxSumWithDFS(y, x, 1, map[y][x]);
                visited[y][x] = false;

                findMaxSumWithTShape(y, x, map[y][x]); // 'ㅗ' 모양 계산
            }
        }

        System.out.println(maxSum);
        br.close();
    }

    private static void findMaxSumWithDFS(int y, int x, int count, int currentSum) {
        if (count == 4) {
            maxSum = Math.max(maxSum, currentSum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (isOutOfBounds(ny, nx) || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            findMaxSumWithDFS(ny, nx, count + 1, currentSum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    private static void findMaxSumWithTShape(int y, int x, int baseSum) {
        int adjacentCount = 0;
        int minAdjacentValue = Integer.MAX_VALUE;
        int totalSum = baseSum;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (isOutOfBounds(ny, nx)) continue;

            adjacentCount++;
            totalSum += map[ny][nx];
            minAdjacentValue = Math.min(minAdjacentValue, map[ny][nx]);
        }

        // 'ㅗ' 모양은 인접한 4칸 중 3칸만 선택 가능
        if (adjacentCount == 4) {
            totalSum -= minAdjacentValue;
        }

        maxSum = Math.max(maxSum, totalSum);
    }

    private static boolean isOutOfBounds(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= M;
    }
}