import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] map = new int[N];
        int max = 0;
        StringTokenizer st =  new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(map[j] < map[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }


}