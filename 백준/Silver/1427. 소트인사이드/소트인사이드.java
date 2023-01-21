import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] charNums = br.readLine().toCharArray();
        int[] nums = new int[charNums.length];
        for(int i =0; i<charNums.length;i++){
            nums[i] = charNums[i] - '0';
        }
        Arrays.sort(nums);
        for(int i = nums.length-1; i>=0; i--){
            sb.append(nums[i]);
        }

        System.out.println(sb);

    }
}