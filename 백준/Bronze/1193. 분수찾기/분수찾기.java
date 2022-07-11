import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt =1;

        while(n>0){
            n-=cnt;
            cnt++;
        }
        cnt--;
        n+=cnt;

        int front = cnt-n+1;
        int back = n;

        if(cnt%2 == 0){
            front = n;
            back = cnt-n+1;
        }

        System.out.println(front + "/" + back);
    }
}