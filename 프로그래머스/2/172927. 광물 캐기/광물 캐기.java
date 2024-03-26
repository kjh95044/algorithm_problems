// 무조건 5개씩 캐야 하니까 그룹을 지어서 다이아몬드 제일 많은 그룹에 다이아 곡갱이를 써야할듯?
// 우선순위큐를 배열로 만들고 순서는 다이아,철,돌 순으로 많은 순서로 해주면 될듯
// 그러고 앞에서부터 다이아 있는만큼 쓰고, 철 많은 만큼, 돌 많은 만큼 순서로 피로도 계산 ㄲ
// 추가로.. 곡갱이로 캘수있는 미네랄보다 더 많으면 그 뒤부터는 저장 하지 말자.

import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int mineralsLength = minerals.length;
        
        if((picks[0] + picks[1] + picks[2]) * 5 < mineralsLength){
            mineralsLength = (picks[0] + picks[1] + picks[2]) * 5;
        }
        
        int groupLength = (mineralsLength/5) 
                                     + (mineralsLength%5 ==0 ? 0 : 1);
        
        
        
        int[][] mineralGroup = new int[groupLength][];
        for(int i=0; i<groupLength; i++){
            mineralGroup[i] = new int[3];
            for(int j=0; j<3; j++){
                mineralGroup[i][j] = 0;
            }
        }
        
        for(int i=0; i<mineralsLength; i++){
            int groupNum = i/5;
            
            System.out.println(groupNum);
            
            if(minerals[i].equals("diamond")){
                mineralGroup[groupNum][0] += 1;
            }else if(minerals[i].equals("iron")){
                mineralGroup[groupNum][1] += 1;
            }else if(minerals[i].equals("stone")){
                mineralGroup[groupNum][2] += 1;
            }
        }
        
        Arrays.sort(mineralGroup, 
                    Comparator.comparingInt((int[] arr) -> arr[0])
                        .thenComparingInt(arr -> arr[1])
                        .thenComparingInt(arr -> arr[2])
                        .reversed()
                   );
        
        for(int i=0; i<mineralGroup.length; i++){
            if(picks[0] > 0){
                answer += mineralGroup[i][0] + 
                    mineralGroup[i][1] + 
                    mineralGroup[i][2];
                picks[0] -= 1;
            } else if(picks[1] > 0){
                answer += mineralGroup[i][0] * 5 +
                    mineralGroup[i][1] + 
                    mineralGroup[i][2];
                picks[1] -= 1;
            } else if(picks[2] > 0){
                answer += mineralGroup[i][0] * 25 +
                    mineralGroup[i][1] * 5 + 
                    mineralGroup[i][2];
                picks[2] -= 1;
            }
            
        }
        
        return answer;
    }
}