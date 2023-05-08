import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] arr;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        arr = new char[N];
        int cnt = 0;
        while (st.hasMoreTokens()) {
            arr[cnt++] = st.nextToken().charAt(0);
        }

        visited = new boolean[10];
        permutation(0, "");
        Collections.sort(resultList);
        
        System.out.println(resultList.get(resultList.size()-1));
        System.out.println(resultList.get(0));

    }

    static boolean[] visited;
    static List<String> resultList = new ArrayList<>();

    private static void permutation(int cnt, String nums) {

        if (cnt == N + 1) {
            resultList.add(nums);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;

            if (cnt == 0) {
                visited[i] = true;
                permutation(cnt + 1, nums + i);
                visited[i] = false;
            } else {
                char now = arr[cnt - 1]; // cnt가 부등호 만족하는 숫자라서 부등호는 숫자 다음
                boolean isPass = false;
                int left = nums.charAt(cnt - 1) - '0';

                if (now == '>') {
                    if (left > i) {
                        isPass = true;
                    }
                } else {
                    if (left < i) {
                        isPass = true;
                    }
                }
                if (isPass) {
                    visited[i] = true;
                    permutation(cnt + 1, nums + i);
                    visited[i] = false;
                }

            }

        }

    }
}