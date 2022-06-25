import java.awt.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n;i++){
            String [] str = br.readLine().split(" ");
            int left_int = Integer.parseInt(str[0]);
            int right_int = Integer.parseInt(str[1]);
            int min = Math.min(left_int, right_int);
            int gcd = 0;
            for(int j =1; j<=min; j++){
                if(left_int %j ==0 && right_int %j == 0){
                    gcd = j;
                }
            }
            bw.write((left_int * right_int / gcd) + "\n");
            bw.flush();
        }

        bw.close();
    }
}