import java.util.Scanner;

public class Main {

    public static int countTrailingZeros(int n) {
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static int findMinimumN(int m) {
        int left = 0;
        int right = m * 5;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int zeroCount = countTrailingZeros(mid);

            if (zeroCount < m) {
                left = mid + 1;
            } else {
                if (zeroCount == m) {
                    result = mid;
                }
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(findMinimumN(m));
    }
}