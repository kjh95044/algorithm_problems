import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int [] cards = new int[N];
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(cards[i] != cards[j] && cards[i] != cards[k] && cards[j] != cards[k]){
                        int sum = cards[i] + cards[j] + cards[k];
                        if(sum <= M)
                            max = Math.max(max, sum);
                    }

                }
            }
        }
        System.out.println(max);
    }
}