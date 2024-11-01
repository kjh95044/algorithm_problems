import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i=0; i<N; i++){
                int rankA = sc.nextInt();
                int rankB = sc.nextInt();

                arr[rankA-1] = rankB;
            }

            int cnt = 1;
            int rank = arr[0];

            for(int i=1; i<N; i++){
                if(rank > arr[i]){
                    cnt++;
                    rank = arr[i];
                }               
            }
            System.out.println(cnt);
        }
    }
}