import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numMen = Integer.parseInt(st.nextToken());
        int numWomen = Integer.parseInt(st.nextToken());

        int[] menPersonality = new int[numMen + 1];
        int[] womenPersonality = new int[numWomen + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numMen; i++) {
            menPersonality[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numWomen; i++) {
            womenPersonality[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(menPersonality);
        Arrays.sort(womenPersonality);

        int[][] minDifferenceDP = new int[numMen + 1][numWomen + 1];

        for (int i = 1; i <= numMen; i++) {
            for (int j = 1; j <= numWomen; j++) {
                minDifferenceDP[i][j] = minDifferenceDP[i - 1][j - 1] + Math.abs(menPersonality[i] - womenPersonality[j]);
                
                if (i > j) minDifferenceDP[i][j] = Math.min(minDifferenceDP[i][j], minDifferenceDP[i - 1][j]);
                
                if (i < j) minDifferenceDP[i][j] = Math.min(minDifferenceDP[i][j], minDifferenceDP[i][j - 1]);
            }
        }

        System.out.println(minDifferenceDP[numMen][numWomen]);
    }
}