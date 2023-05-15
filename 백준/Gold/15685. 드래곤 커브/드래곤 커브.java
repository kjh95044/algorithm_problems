import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T, x, y, d, g, result;
    static int[][] delta = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우상좌하
    static boolean[][] map = new boolean[101][101]; // x,y가 0~100

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            dragonGo();


        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void dragonGo() {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for(int i=1; i<= g; i++){
            int size = list.size();
            for(int j = 1; j <=size; j++){ // 뒤에서
                list.add((list.get(size -j) + 1) %4);
            }
        }

        map[x][y] = true;

        for (Integer d : list) {
            x += delta[d][0];
            y += delta[d][1];
            map[x][y] = true;
        }
    }
}