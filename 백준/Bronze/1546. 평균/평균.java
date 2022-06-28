import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] inputs = br.readLine().split(" ");
        double result = 0;

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            numbers.add(Integer.parseInt(inputs[i]));
        }

        int M = Collections.max(numbers);
        for(int i = 0; i < n; i++){
            result += Double.valueOf(numbers.get(i)) / M * 100;
        }

        System.out.println(result/n);
    }
}