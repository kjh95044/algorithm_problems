import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib(N);
        fib2(N);

        System.out.println(cnt + " " + cnt2);
    }

    public static int fib(int n){
        if (n == 1 || n == 2){
            cnt++;
            return 1;
        }
        else
            return (fib(n-1) + fib(n -2));
    }

    public static int fib2(int n){
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
            cnt2++;
        }
        return f[n];
    }
}