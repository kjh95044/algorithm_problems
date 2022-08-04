import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[3];
        for(int i=0; i<3; i++) 
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        for (int i : num)
            System.out.print(i+" ");
    }
}
