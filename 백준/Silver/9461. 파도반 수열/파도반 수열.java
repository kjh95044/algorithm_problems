import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());


        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(sol(n)).append("\n");
        }
        System.out.println(sb);
    }

    private static long sol(int n) {
        for(int i=6; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        return dp[n];
    }
}