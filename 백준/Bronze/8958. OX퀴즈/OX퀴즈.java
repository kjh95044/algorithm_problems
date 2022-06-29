import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for(int i =0; i<n ; i++){
            int record = 0;
            int result = 0;
            
            String [] str = br.readLine().split("");
            for(int j=0; j< str.length; j++){
                if(str[j].equals("O")){
                    record++;
                    result+= record;
                }
                else{
                    record = 0;
                }
            }
            System.out.println(result);
            
        }
    }
}