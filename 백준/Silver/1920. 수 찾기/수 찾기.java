import java.util.*;
import java.io.*;

public class Main {
    static int [] n_nums;
    static int [] m_nums;
    public static int isExistNum(int n){
        int start = 0;
        int end = n_nums.length-1;
        int mid = (end+start) /2;

        while(end - start >=0){
            if(n_nums[mid] == n)
                return 1;
            else if (n_nums[mid] > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (end+start)/2;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n_nums = new int[n];

        for(int i=0; i<n; i++){
            n_nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        m_nums = new int[m];

        for(int i=0; i<m; i++){
            m_nums[i] = (Integer.parseInt(st2.nextToken()));
        }

        Arrays.sort(n_nums);

        for(int a : m_nums){
            sb.append(isExistNum(a));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
