import java.util.*;
import java.io.*;

class Main {
    public static int factorial(int n){
        int result = 1;
        if(n>0)
            result = n * factorial(n-1);
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(factorial(n));
    }
}