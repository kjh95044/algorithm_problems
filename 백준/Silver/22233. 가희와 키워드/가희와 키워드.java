import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        for(int i=0; i<N; i++){
            map.put(br.readLine(),0);
        }
        
        for(int i=0; i<M; i++){
            input = br.readLine();
            String[] spStr = input.split(",");
            for(int j=0; j<spStr.length; j++){
                if(map.containsKey(spStr[j])){
                    map.remove(spStr[j]);
                }
            }
            System.out.println(map.size());
        }

    }
}