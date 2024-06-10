import java.util.*;

class Solution {
    // 가장 많은 종류의 폰켓몬을 얻으려 한다.
    // 선택은 N/2 마리 할수있다.
    
    public int solution(int[] nums) {
        int answer = 0;
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i : nums){
//             map.put(i, map.getOrDefault(i,0) + 1);
//         }
        
//         if(map.size() > nums.length/2){
//             answer = nums.length/2;
//         }else{
//             answer = map.size();
//         }
        answer = (int)Math.min(Arrays.stream(nums).boxed().distinct().count(), (int)(nums.length/2));
        
        return answer;
    }
}