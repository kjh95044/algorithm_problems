import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() != S.length()) {
            char c = T.charAt(T.length() - 1);
            // 뒤에서 제거 하는데 B였을 경우에만 reverse
            T.deleteCharAt(T.length() - 1);
            if (c == 'B') {
                T.reverse();
            }
        }

        int result;
        if (S.toString().equals(T.toString())) {
            result = 1;
        } else {
            result = 0;
        }

        System.out.println(result);
    }
}