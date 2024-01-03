import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, M;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M + 1];

        // 초기화
        for (int i = 0; i <= M; i++) {
            dp[i] = -1;
        }

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        dp[S] = 0;

        for (int i = 0; i < N; i++) {
            int value = arr[i];
            int[] nextDP = dp.clone(); // 현재 상태를 유지한 채로 다음 dp 배열을 생성

            for (int j = 0; j <= M; j++) {
                if (dp[j] == i) {
                    int plus = j + value;
                    int minus = j - value;

                    if (plus <= M) nextDP[plus] = i + 1;
                    if (minus >= 0) nextDP[minus] = i + 1;
                }
            }

            dp = nextDP; // 다음 dp 배열로 업데이트
        }

        // 최대값 찾기
        int max = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}