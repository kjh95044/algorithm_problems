import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int N, int from, int to, int temp){
        if(N == 0){
            return;
        }

        hanoi(N-1, from, temp, to);

        sb.append(from + " " + to + "\n");

        hanoi(N-1, temp, to, from);
    }

    public static int hanoiResult(int N){
        return  (int)Math.pow(2,N) - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb.append(hanoiResult(N) + "\n");
        hanoi(N, 1, 3, 2);
        System.out.println(sb);
    }
}