import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            for(int i=0; i<N; i++){
                arrA[i] = sc.nextInt();
            }

            for(int i=0; i<M; i++){
                arrB[i] = sc.nextInt();
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int cnt=0;

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arrA[i]>arrB[j]){
                        cnt++;
                    }else{
                        break;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}