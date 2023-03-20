import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int A,B,N,M;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static HashMap<Integer, Robot> robots = new HashMap<>();

    static class Robot{
        int no, x, y;
        int dir; // 상우하좌 N E S W
        public Robot(int no, int x, int y, int dir) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[A][B];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x;
        int y;
        char dirChar;
        int dir = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dirChar = st.nextToken().charAt(0);
            switch (dirChar){
                case 'N':
                    dir = 0;
                    break;
                case 'E':
                    dir = 1;
                    break;
                case 'S':
                    dir = 2;
                    break;
                case 'W':
                    dir = 3;
                    break;
            }

            map[x-1][y-1] = i+1;
            robots.put(i+1, new Robot(i+1,x-1,y-1,dir));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNo = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());

            if(move(robotNo,cmd,cnt)){
                return;
            }
        }

        System.out.println("OK");
    }

    private static boolean move(int robotNo, char cmd, int cnt) {
        Robot curRobot = robots.get(robotNo);
        boolean isOver = false;

        switch (cmd){
            case 'L':
                curRobot.dir = (curRobot.dir - cnt%4) % 4 <0 ? (curRobot.dir - cnt%4) % 4 + 4 : (curRobot.dir - cnt%4) % 4;
                break;
            case 'R':
                curRobot.dir = (curRobot.dir + cnt%4) % 4;
                break;
            case 'F':
                int nx = curRobot.x;
                int ny = curRobot.y;
                for(int i=0; i<cnt; i++){
                    nx = nx + delta[curRobot.dir][0];
                    ny = ny + delta[curRobot.dir][1];

                    if(!(nx>=0 && ny>=0 && nx<A && ny<B)){
                        System.out.println("Robot " + curRobot.no + " crashes into the wall");
                        return true;
                    }

                    if(map[nx][ny]!=0){
                        System.out.println("Robot "+ curRobot.no +" crashes into robot "+ map[nx][ny]);
                        return true;
                    }
                }
                map[curRobot.x][curRobot.y] = 0;
                map[nx][ny] = curRobot.no;
                curRobot.x = nx;
                curRobot.y = ny;
                break;
        }

        robots.replace(curRobot.no, curRobot);

        return isOver;
    }

}