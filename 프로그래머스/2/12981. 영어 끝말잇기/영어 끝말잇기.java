import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            char preLastChar = words[i-1].toCharArray()[words[i-1].length() -1];
            char nowFirstChar = words[i].toCharArray()[0];
            
            if(preLastChar != nowFirstChar) {
                answer[0] = (i) % n + 1;
                answer[1] = (i) / n + 1;
                return answer;
            }
            
            
            int setSize = set.size();
            set.add(words[i]);
            
            // 중복이면 set의 크기가 증가하지 않기 때문에 이전 사이즈와 같으면 이미 말했던 단어이다.
            if(set.size() == setSize){
                answer[0] = (i) % n + 1;
                answer[1] = (i) / n + 1;
                return answer;
            }
        }
        
        answer[0] = 0;
        answer[1] = 0;
        
        return answer;
    }
}