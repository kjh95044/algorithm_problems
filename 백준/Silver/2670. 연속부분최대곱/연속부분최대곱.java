import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double arr[] = new double[N];
        double max = Double.MIN_VALUE;

        for(int i=0; i<N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        for(int i=1; i<N; i++){
            if(arr[i-1] * arr[i] > arr[i]){
                arr[i] = arr[i-1] * arr[i];
            }
            max = Math.max(arr[i], max);
        }


        System.out.printf("%.3f", max);
    }

}