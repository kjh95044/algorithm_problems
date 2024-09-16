import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] time = new int[100001];
    static int[] ways = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(time[K]);
        System.out.println(ways[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        time[N] = 0;
        ways[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) continue;

            int[] nextPositions = {now * 2, now - 1, now + 1};

            for (int next : nextPositions) {
                if (next < 0 || next > 100000) continue;

                if (time[next] == 0 && next != N) {
                    time[next] = time[now] + 1;
                    ways[next] = ways[now];
                    queue.offer(next);
                } else if (time[next] == time[now] + 1) {
                    ways[next] += ways[now];
                }
            }
        }
    }
}