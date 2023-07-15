import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
            1.현재 복사한걸 붙여넣는게 정답이랑 더 가까우면 그걸 하고
                그게 아니면 새로 복사 한다.
            2. 복사 붙여넣기 붙여넣
        */


        System.out.println(bfs(N));

    }

    private static class Emo {
        int value;
        int clip;
        int cnt;

        public Emo(int value, int clip, int cnt) {
            this.value = value;
            this.clip = clip;
            this.cnt = cnt;
        }
    }

    private static int bfs(int N) {
        Queue<Emo> queue = new ArrayDeque<>();
        queue.offer(new Emo(1, 0, 0));
        boolean[][] visited = new boolean[1000 * 2 + 1][1000 * 2 + 1]; // 앞에는 현재 이모티콘 개수, 뒤에는 복사된 이모티콘 개수

        visited[1][0] = true;
        while (!queue.isEmpty()) {
            Emo cur = queue.poll();

            if (cur.value == N) return cur.cnt;

            if (cur.value < N) {
                // 클립보드 저장
                if (!visited[cur.value][cur.value]) {
                    queue.offer(new Emo(cur.value, cur.value, cur.cnt + 1));
                    visited[cur.value][cur.value] = true;
                }

                // 클립보드 붙여넣기
                if ((cur.clip != 0) && !visited[cur.value + cur.clip][cur.clip]) {
                    queue.offer(new Emo(cur.value + cur.clip, cur.clip, cur.cnt + 1));
                    visited[cur.value + cur.clip][cur.clip] = true;
                }
            }
            // 이모티콘 삭제
            if ((cur.value != 0) && !visited[cur.value - 1][cur.clip]) {
                queue.offer(new Emo(cur.value - 1, cur.clip, cur.cnt + 1));
                visited[cur.value - 1][cur.clip] = true;
            }

        }
        return -1;
    }
}