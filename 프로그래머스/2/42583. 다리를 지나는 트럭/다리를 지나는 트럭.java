import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight = 0;
        int watingTruck = 0;
        int idx = 0;
        Deque<Integer> bridge = new ArrayDeque<>();
                
        for(int i=0; i<bridge_length; i++){
            bridge.add(0);
        }
        
        if(bridge_length == 1) 
            return truck_weights.length+1;
        if(truck_weights.length == 1) 
            return bridge_length+1;
               
        while(idx < truck_weights.length) {
            bridgeWeight -= bridge.poll();
            answer++;
            
            if(bridgeWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                bridgeWeight += truck_weights[idx++];
            }
            else bridge.offer(0);
        }
        
        return answer + bridge_length;
    }
}