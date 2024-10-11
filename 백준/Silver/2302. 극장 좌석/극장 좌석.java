import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 1;
        int cnt = 0;
        int[] arr = new int[M];
        int[]dp = new int[41];

        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        for (int vip : arr) {
            result *= dp[vip-cnt-1];
            cnt = vip;
        }
        
        result *= dp[N-cnt];
        System.out.println(result);
    }
}