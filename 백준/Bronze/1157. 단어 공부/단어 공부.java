import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap <Character, Integer> alphaNum = new HashMap<>();
        int max = -1;
        char result = '?';

        String str = br.readLine();
        str = str.toUpperCase();

        for(int i=0; i<str.length(); i++){
            char alpha =str.charAt(i);
            if(alphaNum.containsKey(alpha)){
                alphaNum.put(alpha, alphaNum.get(alpha) + 1);
            }
            else{
                alphaNum.put(alpha, 1);
            }
        }
        for(char a : alphaNum.keySet()){
            if(alphaNum.get(a) == max)
                result = '?';
            else if(alphaNum.get(a) > max){
                max = alphaNum.get(a);
                result = a;
            }
        }

        System.out.println(result);

    }
}