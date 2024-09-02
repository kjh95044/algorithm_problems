import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static double winPer;
    static double losePer;
    static double drawPer;

    static double[][] dp;

    static int[] ranges = {500, 1000, 1500, 2000, 2001};
    static double[] results = {0, 0, 0, 0, 0};

    static void dp() {
        for (int i = 1; i <= 20; i++) { // 20게임
            for (int j = 0; j <= 2000; j++) {
                if (dp[i - 1][j] > 0) {
                    dp[i][j + 50] += dp[i - 1][j] * winPer;
                    dp[i][j - 50] += dp[i - 1][j] * losePer;
                    dp[i][j] += dp[i - 1][j] * drawPer;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        winPer = Double.parseDouble(st.nextToken());
        losePer = Double.parseDouble(st.nextToken());
        drawPer = Double.parseDouble(st.nextToken());

        dp = new double[21][2001]; // 2000점부터 시작해 최소 1000점, 최대 3000점이기 때문에 1000점을 미리 깎는다.
        dp[0][1000] = 1;

        dp();

        int idx = 0;
        for (int i = 0; i <= 2000; i++) {
            if (i == ranges[idx]) {
                idx++;
            }
            results[idx] += dp[20][i];
        }

        for(int i=0; i<5; i++){
            System.out.printf("%.8f\n", results[i]);
        }
    }


}