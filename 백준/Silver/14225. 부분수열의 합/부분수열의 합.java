import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] S = new int[n];

        for (int i = 0; i < n; i++) {
            S[i] = sc.nextInt();
        }

        Arrays.sort(S);

        int target = 1;

        for (int num : S) {
            if (num > target) {
                break;
            }
            target += num;
        }
        System.out.println(target);
    }
}