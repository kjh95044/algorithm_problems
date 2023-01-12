import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    static int[][] map;
    static int[][] visited;
    //좌우상하
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    private static String solution(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1});

        while (!q.isEmpty()){
            int[] temp_xy = q.poll();
            int x = temp_xy[0];
            int y = temp_xy[1];


            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(map[nx][ny] == 3)
                    return "1";

                if(nx < 16 && ny < 16 && map[nx][ny] == 0 && visited[nx][ny] == 0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }

        return "0";
    }


    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[16][16];

        for(int i=1; i<=10; i++){
            visited = new int[16][16];
            sb.append("#").append(i).append(" ");
            br.readLine();
            for(int j=0; j<16; j++) {
                String nums = br.readLine();
                int cnt = 0;
                for(char c : nums.toCharArray()){
                    map[j][cnt] = Integer.parseInt(Character.toString(c));
                    cnt ++;
                }
            }
            sb.append(solution()).append("\n");
        }
        System.out.println(sb);
    }
}