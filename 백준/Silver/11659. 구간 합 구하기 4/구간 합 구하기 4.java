import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] =Integer.parseInt(st.nextToken());
        }

        int[] sums = new int[n];
        sums[0] = nums[0];
        for(int i = 1; i<n; i++){
            sums[i] = sums[i-1] + nums[i];
        }

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a-2<0)
                System.out.println(sums[b-1]);
            else
                System.out.println(sums[b-1]-sums[a-2]);
        }
    }
}