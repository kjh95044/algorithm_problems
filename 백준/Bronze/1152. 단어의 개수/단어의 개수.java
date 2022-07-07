import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = br.readLine().split(" ");
        int result =0;

        if(strs.length==0)
            System.out.println(0);
        else {
            for (String str : strs) {
                if (!str.equals(""))
                    result++;
            }
            System.out.println(result);
        }
    }
}