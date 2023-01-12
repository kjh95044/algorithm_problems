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

    private static String solution(int start_x, int start_y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x,start_y});

        while (!q.isEmpty()){
            int[] temp_xy = q.poll();
            int x = temp_xy[0];
            int y = temp_xy[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(map[nx][ny] == 3)
                    return "1";

                if(nx < 100 && ny < 100 && map[nx][ny] == 0 && visited[nx][ny] == 0){
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

        map = new int[100][100];
        int start_x = 0;
        int start_y = 0;

        for(int i=1; i<=10; i++){
            visited = new int[100][100];
            sb.append("#").append(i).append(" ");
            br.readLine();
            for(int j=0; j<100; j++) {
                String nums = br.readLine();
                int cnt = 0;
                for(char c : nums.toCharArray()){
                    if(c=='2'){
                        start_x = j;
                        start_y = cnt;
                    }
                    map[j][cnt] = Integer.parseInt(Character.toString(c));
                    cnt ++;
                }
            }
            sb.append(solution(start_x, start_y)).append("\n");
        }
        System.out.println(sb);
    }
}