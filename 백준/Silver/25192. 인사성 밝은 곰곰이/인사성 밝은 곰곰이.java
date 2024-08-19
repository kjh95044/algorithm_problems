import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] array = new String[N];

        Set<String> set = new HashSet<>();
        int result = 0;

        for(int i=0; i<N; i++) {
            array[i] = br.readLine();
        }

        for(int i=0; i<N; i++) {
            if(array[i].equals("ENTER")){
                result += set.size();
                set = new HashSet<>();
            }else{
                set.add(array[i]);
            }
        }

        result += set.size();
        System.out.println(result);
    }

}