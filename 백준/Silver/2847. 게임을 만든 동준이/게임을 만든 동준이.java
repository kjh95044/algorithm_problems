import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int past = 0;
        int sum = 0;
        boolean is_changed = true;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        while(is_changed) {
            is_changed = false;
            for (int i = 0; i < n; i++) {
                int now = array[i];
                if (i != 0 && past >= now) {
                    array[i-1] = array[i-1]- (past - now +1);
                    sum += (past - now +1);
                    is_changed = true;
                }
                past = now;
            }
        }
        System.out.println(sum);
    }
}