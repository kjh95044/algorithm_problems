import java.util.*;
import java.io.*;

class Main {
    public static int fibonacci(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(fibonacci(n));
    }
}