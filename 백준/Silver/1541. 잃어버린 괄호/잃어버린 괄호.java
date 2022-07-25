import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String integrated_str = br.readLine();
        int sum = 0;

        if(integrated_str.contains("-")){
            String[] integers_minus = integrated_str.split("-");
            for(int i=0; i<integers_minus.length; i++){
                String[] integers_plus = integers_minus[i].split("\\+");
                for(String plus : integers_plus){
                    if(i==0)
                        sum+= Integer.parseInt(plus);
                    else
                        sum-= Integer.parseInt(plus);
                }
            }
        }
        else{
            String[] integers = integrated_str.split("\\+");
            for(String integer : integers){
                sum+= Integer.parseInt(integer);
            }
        }
        System.out.println(sum);
    }
}