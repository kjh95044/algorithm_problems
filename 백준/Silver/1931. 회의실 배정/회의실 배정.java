import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, (d1,d2) -> {
            if(d1[1] == d2[1])
                return d1[0] - d2[0];
            else
                return d1[1] - d2[1];
        });
        int end_time = data[0][1];
        int cnt =0;

        for (int i = 0; i < n; i++) {
            if(i==0){
                cnt++;
                continue;
            }
            if (data[i][0] >= end_time) {
                cnt++;
                end_time = data[i][1];
            }
        }
        System.out.println(cnt);
    }
}