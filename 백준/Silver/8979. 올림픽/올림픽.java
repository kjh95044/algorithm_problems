import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][] data = new int[N][4];
        int rank =1;
        int [] K_medal = new int[4];

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st2.nextToken());
            data[i][1] = Integer.parseInt(st2.nextToken());
            data[i][2] = Integer.parseInt(st2.nextToken());
            data[i][3] = Integer.parseInt(st2.nextToken());

            if(data[i][0] == K)
                K_medal = data[i].clone();
        }
        
        for(int i=0; i<N; i++){
            if(data[i][0] != K_medal[0]) {
                if (data[i][1] > K_medal[1]) {
                    rank++;
                } else if (data[i][1] == K_medal[1] && data[i][2]> K_medal[2]) {
                    rank++;
                } else if (data[i][1] == K_medal[1] && data[i][2]== K_medal[2] &&data[i][3]> K_medal[3]) {
                    rank++;
                }
            }
        }
        System.out.println(rank);
    }
}
