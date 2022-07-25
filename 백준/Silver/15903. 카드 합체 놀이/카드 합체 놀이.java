import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Long> nums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            nums.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            Collections.sort(nums);
            Long sum = nums.get(0) + nums.get(1);
            nums.set(0, sum);
            nums.set(1, sum);
        }

        Long sum = 0L;
        for(Long value : nums){
            sum+= value;
        }
        System.out.println(sum);

    }

}