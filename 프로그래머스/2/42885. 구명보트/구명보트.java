// 일단 리미트 넘어가는 무게는 카운트 따로 해준다.
// 남은 애들중에 짝을 지어줘야하는데..
// 남은 애들중에 짝을 지어주는데 그 합이 리미트에 가까운 순서로 해주면 되려나
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i=people.length-1; i>=0; i--){
            if(people[i] >= limit)
                answer++;
            else{
                queue.addLast(people[i]);
            }
        }
        
        while(!queue.isEmpty()){
            int first = queue.peekFirst();
            int second = queue.peekLast();
            
            if(first + second <= limit){
                queue.pollLast();
            }
            
            queue.pollFirst();
            answer++;
            
        }
        
        return answer;
    }
}