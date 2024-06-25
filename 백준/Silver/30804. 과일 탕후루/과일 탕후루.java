import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        int max = Integer.MIN_VALUE;
        int types = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 투 포인터로 완전 탐색

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[10];
        int left = 0;

        for(int right=0; right< N; right++){
            if (nums[array[right]] == 0){ // 과일 중복 체크 (0이면 해당 과일 없음)
                types++;
            }

            nums[array[right]] ++;

            while(types > 2) { // 과일의 종류가 2종류를 넘으면, 왼쪽의 포인트를 우측으로 이동

                if (--nums[array[left]] == 0) {
                    types--;
                }
                left ++;
            }
                max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}