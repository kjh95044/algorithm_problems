import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=(n-(String.valueOf(n).length()*9)); i< n; i++){
            int num = i;
            int sum =0;

            while(num !=0){
                sum += num %10;
                num /=10;
            }

            if(sum + i == n){
                result = i;
                break;
            }

        }
        System.out.println(result);
    }
}