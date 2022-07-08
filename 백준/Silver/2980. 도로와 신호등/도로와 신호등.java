import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int now_location = 0;
        int time = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st2.nextToken());
            int R = Integer.parseInt(st2.nextToken());
            int G = Integer.parseInt(st2.nextToken());

            while(now_location != D){
                time++;
                now_location++;
            }

            while(time%(R+G) < R){
                time++;
            }
        }
        while(L != now_location){
            time++;
            now_location ++;
        }

        System.out.println(time);
    }
}
