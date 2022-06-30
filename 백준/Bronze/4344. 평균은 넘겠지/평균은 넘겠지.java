import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(tokenizer.nextToken());
            int[] score = new int[num];
            int overAverage = 0;

            for(int j = 0; j<num; j++){
                score[j] = Integer.parseInt(tokenizer.nextToken());
            }

            double average = Arrays.stream(score).average().getAsDouble();

            for(int j =0; j<num; j++){
                if(score[j] > average){
                    overAverage++;
                }
            }
            System.out.printf("%.3f", (double) overAverage * 100.0 / (double) num);
            System.out.println("%");
        }
    }
}