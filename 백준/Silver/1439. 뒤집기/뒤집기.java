import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st0 = new StringTokenizer(str, "1");
        StringTokenizer st1 = new StringTokenizer(str, "0");

        bw.write(Math.min(st0.countTokens(), st1.countTokens()) + "\n");
        bw.flush();
        bw.close();
    }
}
