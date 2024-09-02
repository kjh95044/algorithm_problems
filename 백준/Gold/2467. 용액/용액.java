import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String result;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        Solution(arr);

        System.out.println(result);

    }

    public static void Solution(int[] arr){
        int left = 0;
        int right = arr.length -1;
        int sum;

        while(left < right){
            sum = arr[left] + arr[right];
            int sumAbs = Math.abs(arr[left] + arr[right]);
            if(sumAbs < min){
                min = sumAbs;
                result = arr[left] + " " + arr[right];
            }
            if(sum==0) return;

            if(sum < 0){
                left += 1;
            }else{
                right -= 1;
            }

        }
    }

}