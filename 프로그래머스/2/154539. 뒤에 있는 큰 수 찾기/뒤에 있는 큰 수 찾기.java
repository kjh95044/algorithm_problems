class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                if(j == numbers.length-1){
                    answer[i] = -1;
                    break;
                }else if(numbers[i] < numbers[j+1]){
                    answer[i] = numbers[j+1];
                    break;
                }
            }
        }
        
        return answer;
    }
}