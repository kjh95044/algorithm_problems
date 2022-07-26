import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n>1){
            for(int i=2; i<10000000; i++) {
                if (n % i == 0) {
                    n = n / i;
                    sb.append(i);
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}