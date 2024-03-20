import java.util.*;
class Solution {
    static int nums;
    
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
     
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        
        
        nums = 1;
            
        map.values().forEach((val) -> nums = nums * (val+1));
        answer += nums -1;
        
        return answer;
    }
}