import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        calculate(number[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void calculate(int num, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        calculate(num + number[index], index + 1);
                        break;
                    case 1:
                        calculate(num - number[index], index + 1);
                        break;
                    case 2:
                        calculate(num * number[index], index + 1);
                        break;
                    case 3:
                        calculate(num / number[index], index + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}