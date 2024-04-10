import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Boolean isAllK = false;
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pQueue.add(scoville[i]);
        }
        
        while(!pQueue.isEmpty()){
            int firstScoville = pQueue.poll();
            int secondScoville;
            
            // 스코빌 지수가 모두 K 이상일 경우에 반환
            if(firstScoville >= K){
                isAllK = true;
                break;
            }
            
            if(!pQueue.isEmpty()){
                secondScoville = pQueue.poll();
                pQueue.add(firstScoville + secondScoville * 2);
                
                answer ++;
            }

        }
        
        return isAllK ? answer : -1; // 
    }
}

