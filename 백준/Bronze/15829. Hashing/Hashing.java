import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String input = br.readLine();
        long result = 0;
        char[] chars = input.toCharArray();
        int cnt = 0;
        for(char ch : chars){
            int num = ch - 'a' + 1;
            result += num * myPow(31, cnt++);
        }

        System.out.println(result % 1234567891);

    }

    public static long myPow(int a, int b){
        long result = 1;
        for(int i=0; i<b; i++){
            result = (result * a) % 1234567891;
        }
        return result;
    }
}