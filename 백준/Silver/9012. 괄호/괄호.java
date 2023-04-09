import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Queue<Character> q = new ArrayDeque<>();

        for (int n = 0; n < N; n++) {
            String input = in.readLine();
            boolean isVPS = true;
            q.clear();

            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i)== '('){
                    q.offer('(');
                }else{
                    if(q.isEmpty()){
                        isVPS = false;
                        break;
                    }
                    q.poll();
                }
            }
            if(!q.isEmpty()){
                isVPS = false;
            }
            if(isVPS){
                sb.append("YES");
            }
            else {
                sb.append("NO");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}