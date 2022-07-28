import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            } else if (cmd.equals("pop")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.poll());
            } else if (cmd.equals("size")) {
                sb.append(queue.size());
            } else if (cmd.equals("empty")) {
                if(queue.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
            } else if (cmd.equals("front")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.peek());
            } else if (cmd.equals("back")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(num);
            }
            if(!cmd.equals("push"))
                sb.append("\n");
        }
        System.out.print(sb);
    }
}