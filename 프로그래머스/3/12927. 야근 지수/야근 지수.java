import java.util.*;

// 야근 피로도 = 남은 일의 작업량 ^2 를 모두 더한 값
// N시간 동안 야근 피로도를 최소화 해라

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n; i++){
            if(!pq.isEmpty()){
                int work = pq.poll();
                if(work-1>0){
                    pq.add(work-1);
                }
            }
        }
        
        while(!pq.isEmpty()){
            answer += (int) Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}
