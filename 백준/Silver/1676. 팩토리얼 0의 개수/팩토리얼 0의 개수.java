import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger sum = BigInteger.valueOf(1);
        int result = 0;

        for(int i=2; i<=N; i++){
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        char[] nums = sum.toString().toCharArray();

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]=='0'){
                result ++;
            }else{
                break;
            }
        }

        System.out.println(result);
    }

}