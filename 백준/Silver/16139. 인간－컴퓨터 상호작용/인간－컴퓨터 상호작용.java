import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[input.length()+1]['z' - 'a' + 1];

        arr[1][input.charAt(0)-'a'] = 1; // 첫 알파벳 +1

        for (int i = 2; i <= input.length(); i++) {
            for (int j = 0; j <= 'z' - 'a'; j++) {
                arr[i][j] = arr[i-1][j];  // 이전값 다 더해주기
            }

            arr[i][input.charAt(i-1)-'a'] += 1; // 현재 i에 해당하는 알파벳 +1 해주기
        }

        int N = Integer.parseInt(in.readLine());
        int result;

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            char c = st.nextToken().charAt(0);

            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            result = arr[end][c-'a'] - arr[start-1][c-'a'];
            sb.append(result).append("\n");
        }

        System.out.println(sb);


    }
}