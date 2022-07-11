import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n>0){
            if(cnt == 0)
                n  -= 1;
            else{
                n = n - (cnt * 6);
            }
            cnt ++;
        }
        System.out.println(cnt);
    }
}