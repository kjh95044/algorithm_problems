import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            long result = 0;
            int days = Integer.parseInt(br.readLine());
            int max = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> num_list = new ArrayList<>();
            for(int j = 0; j< days; j++){
                num_list.add(Integer.parseInt(st.nextToken()));
            }

            

            for(int j=days-1; j>=0; j--){
                int val = num_list.get(j);
                if(val > max){
                    max = val;
                }
                if(val < max){
                    result += max - val;
                }
            }
            bw.write(String.valueOf(result) + "\n");

        }
        bw.flush();
        bw.close();
    }
}
