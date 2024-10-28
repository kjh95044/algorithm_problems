import java.util.*;
import java.io.*;

public class Main {

    static class Charger {
        int cnt;
        boolean isUse;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);

        Charger[] chargers = new Charger[N + 1];
        for (int i = 1; i <= N; i++) {
            chargers[i] = new Charger();
        }
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            available.add(i);
        }

        int cnt = 1;

        for (int q = 0; q < Q; q++) {
            input = br.readLine().split(" ");
            int type = Integer.parseInt(input[0]);
            int i = Integer.parseInt(input[1]);

            Charger charger = chargers[i];

            if (type == 1) {
                Integer assignIdx = available.ceiling(i);
                if (assignIdx == null) {
                    sb.append(-1).append("\n");
                } else {
                    chargers[assignIdx].cnt = cnt;
                    chargers[assignIdx].isUse = true;
                    available.remove(assignIdx);
                    sb.append(assignIdx).append("\n");
                }
            } else if (type == 2) {
                if (charger.isUse) {
                    sb.append(charger.cnt).append("\n");
                    charger.isUse = false;
                    available.add(i);
                } else {
                    sb.append(-1).append("\n");
                }
            }
            cnt++;
        }
        System.out.print(sb);
    }
}