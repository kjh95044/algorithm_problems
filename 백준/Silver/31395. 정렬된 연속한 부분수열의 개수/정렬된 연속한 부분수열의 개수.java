import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int[] dp = new int[N];

        for (int i = 1; i < N; i++) {
            if(array[i-1] < array[i]){
                dp[i] = dp[i-1] + 1;
            }
        }

        for(int i = 0; i < N; i++){
            result += dp[i];
        }

        System.out.println(result + N);

    }
}