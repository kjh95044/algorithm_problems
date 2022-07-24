import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;

        boolean[] primes = isPrimeNums(M, N);

        for(int i=M; i<=N; i++){
            if(primes[i]){
                if(sum==0)
                    min = i;
                sum+= i;
            }
        }

        if(sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    public static boolean[] isPrimeNums(int M, int N){
        boolean[] nums = new boolean[N+1];
        Arrays.fill(nums,true);
        nums[0] = nums[1] = false;

        for(int i = 2; i<Math.sqrt(N+1); i++){
            if(!nums[i]){
                continue;
            }

            for(int j = i*i; j<N+1; j+=i){
                nums[j] = false;
            }
        }

        return nums;
    }
}