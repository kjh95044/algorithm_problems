import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ACnt = Integer.parseInt(st.nextToken());
        int BCnt = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] APizza = new int[ACnt];
        int[] BPizza = new int[BCnt];

        for (int i = 0; i < ACnt; i++) {
            APizza[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < BCnt; i++) {
            BPizza[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> APizzaSum = new HashMap<>();

        int sum = 0;
        int[] dp = new int[N + 1];
        for (int i = 0; i < APizza.length; i++) {
            
            dp[0] = APizza[i];
            sum += APizza[i];
            APizzaSum.put(APizza[i], APizzaSum.getOrDefault(dp[0], 0) + 1);


            for (int j = 1; j < APizza.length - 1; j++) {

                dp[j] = APizza[(i + j) % APizza.length]
                        + dp[j - 1];
                APizzaSum.put(dp[j], APizzaSum.getOrDefault(dp[j], 0) + 1);
            }
        }
        APizzaSum.put(sum, 1);

        HashMap<Integer, Integer> BPizzaSum = new HashMap<>();

        sum = 0;
        dp = new int[N + 1];
        for (int i = 0; i < BPizza.length; i++) {
            dp[0] = BPizza[i];
            sum += BPizza[i];
            BPizzaSum.put(BPizza[i], BPizzaSum.getOrDefault(dp[0], 0) + 1);
            for (int j = 1; j < BPizza.length - 1; j++) {
                dp[j] = BPizza[(i + j) % BPizza.length]
                        + dp[j - 1];
                BPizzaSum.put(dp[j], BPizzaSum.getOrDefault(dp[j], 0) + 1);
            }
        }
        BPizzaSum.put(sum, 1);

//        System.out.println(APizzaSum);
//        System.out.println(BPizzaSum);

        if (APizzaSum.get(N) != null) {
            result += APizzaSum.get(N);
        }

        if (BPizzaSum.get(N) != null) {
            result += BPizzaSum.get(N);
        }

        for (Map.Entry<Integer, Integer> entry : APizzaSum.entrySet()) {
            if(BPizzaSum.get(N-(entry.getKey()))!=null){
                result += entry.getValue() * BPizzaSum.get(N-entry.getKey());
            }
        }

        System.out.println(result);
    }
}