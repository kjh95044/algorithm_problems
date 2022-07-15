import java.util.*;
import java.io.*;

class Main {
    public static long findMaxLan(int N, int[] lan_length){
        //랜선의 최대 길이는 주어진 랜선의 길이를 초과할수 없으므로, end 를 주어진 랜선들중 max 값으로 잡았다.

        long start =1;
        long end = Arrays.stream(lan_length).max().getAsInt();
        long mid = (end+start)/2;
        long max_lan = 0;

        while(end-start>=0){
            int target_cnt= 0; // 만들어질 랜선 갯수
            for (int j : lan_length) {
                target_cnt += j / mid;
            }
            //이분탐색으로 target_cnt>=N을 만족하는 mid 를 찾고,
            //이를 만족하는 모든 값중 최대값을 찾는다.

            if(target_cnt>=N){
                start = mid +1;
                max_lan = Math.max(max_lan,mid);
            }
            else {
                end = mid - 1;
            }
            mid = (end + start) / 2;
        }
        return max_lan;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan_length = new int[K];

        for(int i=0; i<K; i++){
            lan_length[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findMaxLan(N,lan_length));
    }
}