class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int dp[] = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i< 100001; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        
        answer = dp[n];
        return answer;
    }
}