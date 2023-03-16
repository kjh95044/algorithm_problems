import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<N/4; i++){
            sb.append("long ");
        }
        sb.append("long int");
        System.out.println(sb);
    }
}