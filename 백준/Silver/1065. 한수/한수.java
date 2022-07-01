import java.util.*;
import java.io.*;

public class Main {
    public static boolean isHanNumber(int n){
        String[] str = String.valueOf(n).split("");
        int pre_num = 0;
        int add_num = 0;
        for(int j=0; j< str.length; j++){
            if(j==1)
                add_num = Integer.parseInt(str[j])-pre_num;
            else if(j>1){
                if(add_num != Integer.parseInt(str[j])-pre_num){
                    return false;
                }
            }
            pre_num = Integer.parseInt(str[j]);
        }
        return true;
    }

    public static int countHanNumber(int n){
        if(n<100)
            return n;
        else {
            int result = 99;
            for(int i=100; i<= n; i++){
                if(isHanNumber(i))
                    result ++;
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(countHanNumber(num));
    }
}
