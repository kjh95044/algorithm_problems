import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            map[i] = str.toCharArray();
        }

        int totalChanges = 0;

        for (int x = 0; x < K; x++) {
            for (int y = 0; y < K; y++) {

                HashMap<Character, Integer> countMap = new HashMap<>();
                int stepNum = 0;

                for (int i = x; i < N; i += K) {
                    for (int j = y; j < M; j += K) {
                        char tile = map[i][j];
                        countMap.put(tile, countMap.getOrDefault(tile, 0) + 1);
                        stepNum++;
                    }
                }

                char maxTile = 'A';
                int maxCount = 0;
                for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue() > maxCount) {
                        maxTile = entry.getKey();
                        maxCount = entry.getValue();
                    }
                }

                totalChanges += stepNum - maxCount;
                for (int i = x; i < N; i += K) {
                    for (int j = y; j < M; j += K) {
                        map[i][j] = maxTile;
                    }
                }
            }
        }

        System.out.println(totalChanges);
        for (int i = 0; i < N; i++) {
            System.out.println(new String(map[i]));
        }
    }
}