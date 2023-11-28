import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max = 0;

        int[][] dp = new int [N][N];
        dp[0][0] = Integer.parseInt(br.readLine());
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                int input = Integer.parseInt(st.nextToken());

                if(j==0){
                    dp[i][j] = dp[i-1][0] + input;
                } else if (j==i) {
                    dp[i][j] = dp[i-1][i-1] + input;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + input;
                }

            }
        }

        for(int i=0; i<N; i++){
            max = Math.max(dp[N-1][i], max);
        }
        System.out.println(max);
    }


}