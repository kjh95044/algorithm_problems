
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void merge_sort(int[] A, int p, int r){
        if(p < r){
            int q = (p+r) /2;
            merge_sort(A, p, q);
            merge_sort(A, q+1,r);
            merge(A, p, q, r);
        }
    }

    static int result = -1;
    static int cnt;
    static int K;
    static int[] temp;
    public static void merge(int[] A, int p, int q, int r){
        int i = p;
        int j = q + 1;
        int t = 1;

        while(i <=q && j<=r){
            if(A[i] <= A[j]){
                temp[t++] = A[i++];
            }
            else{
                temp[t++] = A[j++];
            }
        }

        while (i<=q){
            temp[t++] = A[i++];
        }

        while (j<=r){
            temp[t++] = A[j++];
        }

        i= p;
        t=1;
        while (i<=r){
            if(++cnt == K){
                result = temp[t];
            }
            A[i++] = temp[t++];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        temp = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N-1);
        sb.append(result);
        System.out.println(sb);
    }
}