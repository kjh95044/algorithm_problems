import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int result = 1;
        double tape;

        if(N==0){
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        tape = arr[0] - 0.5 + L; // 왼쪽으로부터 테이프까지의 거리
        for(int i=1; i<N; i++){
            if(tape < arr[i] + 0.5){ // 현재 테이프 길이가 이 구멍을 막지 못하면
                tape = arr[i] - 0.5 + L; // 새로운 테이프를 부착
                result ++;
            }
        }

        System.out.println(result);
    }

}