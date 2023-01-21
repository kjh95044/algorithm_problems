import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];
        int sum=0;

        int T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i<x+10; i++){
                for(int j = y; j<y+10; j++){
                    map[i][j] = 1;
                }
            }
        }
        for(int i=1; i<101; i++){
            for(int j=1; j<101; j++){
                if(map[i][j] == 1){
                    sum+=1;
                }
            }
        }
        System.out.println(sum);
    }
}