import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int gcd(int a, int b){ // 최대 공약수
        if(b==0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 소시지 수
        int m = Integer.parseInt(st.nextToken()); // 평론가 수

        // 최소 칼질 : 평론가 수 - 최대 공약수
        System.out.println(m - gcd(n,m));
    }
}