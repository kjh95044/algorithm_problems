import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replaceAll("c=","A");
        str = str.replaceAll("c-","A");
        str = str.replaceAll("dz=","A");
        str = str.replaceAll("d-","A");
        str = str.replaceAll("lj","A");
        str = str.replaceAll("nj","A");
        str = str.replaceAll("s=","A");
        str = str.replaceAll("z=","A");

        System.out.println(str.length());
    }
}