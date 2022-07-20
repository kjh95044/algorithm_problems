import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String p = (br.readLine());
        while(!p.equals("0")){
            StringBuilder sb_p = new StringBuilder(p);
            if(p.equals(sb_p.reverse().toString())){
                sb.append("yes");
            }
            else
                sb.append("no");
            sb.append("\n");
            p = (br.readLine());
        }
        System.out.println(sb);
    }
}