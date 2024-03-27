import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String input = br.readLine();
        int result = 0;
        char[] chars = input.toCharArray();
        int cnt = 0;
        for(char ch : chars){
            int num = ch - 'a' + 1;
            result += num * Math.pow(31, cnt++) % 1234567891;
        }

        System.out.println(result);

    }
}