import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int M;
    static int answer;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = -1;

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int [M+1];

        for(int i=0; i<M+1; i++){
            dp[i] = -1;
        }


        st = new StringTokenizer(br.readLine());

        for(int i =0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        dp[S] = 0; // index가 값, value가 순서

        for(int i=1; i<=N; i++){
            int value = arr[i-1];
            List<Integer> list = new ArrayList<>();

            for(int j=0; j<=M; j++){
                if(dp[j] == i-1){
                    if((j + value) <=M){
                        list.add(j+value);
                    }
                    if((j-value)>=0){
                        list.add(j-value);
                    }
                }
            }

            for(int v : list){
                dp[v] = i;
            }

        }

        int max = -1;
        for(int i =0; i<=M; i++){
            if(dp[i] == N){
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}