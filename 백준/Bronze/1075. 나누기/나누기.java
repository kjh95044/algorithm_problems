import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        
        int t = (n/100)*100;
        while(true) {
            if(t%f == 0) {
                int result = t % 100;
                if(result < 10) 
                    System.out.println("0" + result);
                else 
                    System.out.println(result);
                return;
            }
            t++;
        }
        
    }
}
