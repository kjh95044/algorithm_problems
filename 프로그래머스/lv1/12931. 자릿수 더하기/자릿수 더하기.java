import java.util.*;


public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numbers = String.valueOf(n);
        
        for(int i=0; i< numbers.length(); i++){
            answer += numbers.charAt(i)-'0';
        }
        return answer;
    }
}