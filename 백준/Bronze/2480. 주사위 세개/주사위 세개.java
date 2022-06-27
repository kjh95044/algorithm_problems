import java.awt.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        if (a == b && a == c) {
            System.out.print(10000+a*1000);
        } else if (a == b) {
            System.out.print(1000+a*100);
        } else if (a == c) {
            System.out.print(1000+a*100);
        } else if (b == c) {
            System.out.print(1000+b*100);
        } else {
            System.out.print(Math.max(a,Math.max(b,c)) * 100);
        }
    }
}