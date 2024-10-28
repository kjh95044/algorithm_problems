import java.util.*;
import java.io.*;

public class Main {

    static class Team{
        int score;
        int cnt=1;
        int fifth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();
    
        int T = Integer.parseInt(br.readLine());


        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            Team[] teams = new Team[N+1];

            for(int i=0; i<N; i++){
                teams[i+1] = new Team();
                int value = Integer.parseInt(st.nextToken());
                map.put(value,map.getOrDefault(value,0)+1);
                arr[i] = value;
            }

            int score = 1;
            for(int i=0; i<N; i++){
                if(map.get(arr[i])<6) continue;
                if(teams[arr[i]].cnt==5){
                    teams[arr[i]].fifth = score;
                } else if(teams[arr[i]].cnt<5){
                    teams[arr[i]].score += score;
                }
                teams[arr[i]].cnt += 1;
                score++;
            }

            int winner =0;
            int winScore = 200001;
            int winFifth = 200001;

            for(int i=0; i<N; i++){
                if(teams[arr[i]].score==0 || teams[arr[i]].fifth==0) continue;
                if(teams[arr[i]].score<winScore){
                    winner = arr[i];
                    winScore = teams[arr[i]].score;
                    winFifth = teams[arr[i]].fifth;

                }else if(teams[arr[i]].score == winScore && teams[arr[i]].fifth < winFifth){
                    winner = arr[i];
                    winScore = teams[arr[i]].score;
                    winFifth = teams[arr[i]].fifth;
                }
            }
            System.out.println(winner);
        }

    }
}