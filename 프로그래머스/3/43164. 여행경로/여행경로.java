import java.util.*;

class Solution {
    static ArrayList<String> paths = new ArrayList<>();
    static boolean[] isUsed;
    
    public String[] solution(String[][] tickets) {
        isUsed = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(paths);
        
        return paths.get(0).split(" ");
    }
    
    public void dfs(int depth, String now, String path, String[][] tickets){
        if(depth == tickets.length){
            paths.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!isUsed[i] && now.equals(tickets[i][0])){
                isUsed[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                isUsed[i] = false;
            }
        }
    }
}