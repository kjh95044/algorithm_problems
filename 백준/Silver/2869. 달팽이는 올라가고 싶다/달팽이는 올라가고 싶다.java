import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int n = Integer.parseInt(br.readLine());
        double A = Integer.parseInt(st.nextToken());
        double B = Integer.parseInt(st.nextToken());
        double V = Integer.parseInt(st.nextToken());
        System.out.println((int) Math.ceil((V - B) / (A - B)));
    }
}