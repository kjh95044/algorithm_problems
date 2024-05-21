import java.util.*;

class Solution {
    static int n, m;
    static int answer = -1;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean visited[][];
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(0, 0, maps);
    }
    
    public int bfs(int x, int y, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x,y,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            
            x = temp[0];
            y = temp[1];
            int count = temp[2];
            
            if(x==n-1 && y==m-1){
                answer = count;
                break;
            }
            
            for (int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx <0 || nx >=n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny, count+1});
                }
            }
            
        }
            return answer;
    }
    
}