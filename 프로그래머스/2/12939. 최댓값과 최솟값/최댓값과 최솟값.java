import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}