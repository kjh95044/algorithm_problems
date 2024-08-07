import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minValue = Integer.MAX_VALUE;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        int[][][] dp = new int[n][m][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], 1000001);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<3; j++){
                dp[0][i][j] = array[0][i];
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(j==0){
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + array[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + array[i][j];
                }else if(j==m-1){
                    dp[i][j][1] = dp[i-1][j][2] + array[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + array[i][j];
                }else{
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + array[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + array[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + array[i][j];
                }
            }
        }


        for(int i = 0; i < m; i++) {
            for(int j=0; j<3; j++){
                minValue = Math.min(minValue, dp[n-1][i][j]);
            }
        }
        System.out.println(minValue);
    }

}