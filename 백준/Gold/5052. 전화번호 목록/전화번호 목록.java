import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());




        for(int t =0; t <T; t++){
            int N = Integer.parseInt(in.readLine());
            boolean isYes = true;
            Map<String,Integer> numbers = new HashMap<>();

            for(int i=0; i<N; i++){
                numbers.put(in.readLine(), 0);
            }

            for(String num : numbers.keySet()){
                for(int i=0; i< num.length(); i++){
                    if(numbers.containsKey(num.substring(0, i))){ // 전화 번호의 앞부분들이 numbers에 존재하는지 확인
                        isYes = false;
                        break;
                    }
                }
                if(!isYes) break;
            }

            if(isYes){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");


        }

        System.out.println(sb);

    }
}