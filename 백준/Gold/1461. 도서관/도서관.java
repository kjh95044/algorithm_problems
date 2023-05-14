import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] books = new int[N];

        st = new StringTokenizer(in.readLine());
        int center = 0;

        for(int i=0; i<N; i++){
            books[i] = Integer.parseInt(st.nextToken());

            if(books[i] < 0){ // sort 이후 0위치 찾기
                center ++;
            }
        }

        Arrays.sort(books);

        int result = 0;

        for (int i=0; i< center; i+=M){
            result += Math.abs(books[i]) * 2;
        }

        for(int i = N-1; i>= center; i -= M){
            result += books[i] * 2;
        }

        // 마지막엔 돌아올 필요 없으니 음수 양수 값 중에 더 큰 값 빼준다.
        result -= Math.max(Math.abs(books[0]), Math.abs(books[N-1]));

        System.out.println(result);
    }
}