import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int map[][] = new int[19][19];
    static int delta[][] = {{0,1},{1,1},{1,0},{1,-1}}; // 우,아래오,아래,아래왼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 우,아래오,아래,아래왼 네방향만 체크
        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if(map[i][j] == 0) continue;
                

                for(int d =0; d<4; d++){
                    int cnt = 1;
                    int nx = i + delta[d][0];
                    int ny = j + delta[d][1];

                    if(!(nx >=0 && ny>=0 && nx<19 && ny<19)) continue; // 장외
                    if(map[nx][ny] != map[i][j]) continue; // 다른 바둑알일 경우 or 바둑알이 없을 경우
                    cnt ++;

                    while(true){ // 다른 오목알이 나오거나, 장외로 갈때까지 진행
                        nx = nx + delta[d][0];
                        ny = ny + delta[d][1];
                        if(!(nx >=0 && ny>=0 && nx<19 && ny<19)) break; // 장외
                        if(map[nx][ny] != map[i][j]) break;
                        cnt ++;
                        if(cnt == 5){
                            // 6목이 되면 안됨
                            int tx = nx + delta[d][0];
                            int ty = ny + delta[d][1];
                            if(tx >=0 && ty>=0 && tx<19 && ty<19 && map[tx][ty] == map[i][j])
                                break;
                            tx = i - delta[d][0];
                            ty = j - delta[d][1];
                            if(tx >=0 && ty>=0 && tx<19 && ty<19 && map[tx][ty] == map[i][j])
                                break;

                            System.out.println(map[i][j]);
                            if(ny<j){
                                System.out.println((nx+1) + " " + (ny+1));
                            }else{
                                System.out.println((i+1) + " " + (j+1));
                            }
                            return;
                        }
                    }


                }
            }
        }

        System.out.println(0);
    }

}