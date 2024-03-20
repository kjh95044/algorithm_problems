import java.util.*;

class Solution {
    // 약수를 찾는다.
    // 비교해 가면서 노란색 갯수가 일치하는지를 찾는다.
    
    public ArrayList<Integer> getDivList(int size){      
        ArrayList<Integer> divList = new ArrayList<>();
        
        for(int i=1; i<=Math.sqrt(size); i++){
            if(size%i == 0){
                divList.add(i);
                divList.add(size/i);
            }
        }
        
        Collections.sort(divList);
        return divList;
    }
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Integer> divList = getDivList(brown+yellow);
        System.out.println(divList);
        
        for(int i=0; i<divList.size()/2; i++){
            int row = divList.get(i);
            int col = divList.get(divList.size()-1-i);
            
            if((col-2) * (row-2) == yellow){
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        
        return answer;
    }
}


