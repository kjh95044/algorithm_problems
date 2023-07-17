import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1]; // 진입차수
        int[] time = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list.get(Integer.parseInt(st.nextToken())).add(i);

                inDegree[i]++;
            }
        }

        System.out.println(topologicalSort(N, list, inDegree, time));
    }

    public static int topologicalSort(int N, ArrayList<ArrayList<Integer>> a, int[] inDegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];

            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : a.get(cur)) {
                inDegree[next]--;

                result[next] = Math.max(result[next], result[cur] + time[next]);

                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, result[i]);
        }

        return ans;
    }

}