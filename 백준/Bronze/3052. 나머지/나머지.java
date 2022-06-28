import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> result_set = new HashSet<>();
        
        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            result_set.add(num % 42);
        }
        System.out.println(result_set.size());
    }
}