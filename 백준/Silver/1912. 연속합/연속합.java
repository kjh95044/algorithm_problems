import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(input, dp[i-1] + input);
        }

        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }


}