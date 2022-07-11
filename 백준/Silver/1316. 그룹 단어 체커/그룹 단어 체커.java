import java.util.*;
import java.io.*;

class Main {
    public static boolean isGroupWord(String word){
        Set<Character> alphabet = new HashSet<>();
        char pre_char = 0;

        for(int i=0; i<word.length(); i++){
            char now_char = word.charAt(i);


            if(i>0) {
                if(now_char != pre_char){
                    if(alphabet.contains(now_char)){
                        return false;
                    }
                }
            }
            alphabet.add(now_char);
            pre_char = word.charAt(i);
        }

        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i<n; i++){
            if(isGroupWord(br.readLine())){
                result++;
            }
        }

        System.out.println(result);
    }
}