import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        sb.append(-1);
                    }
                    else {
                        sb.append(stack.pop());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append("\n");
                    break;
                case "top":
                    if(stack.isEmpty()){
                        sb.append(-1);
                    }
                    else {
                        sb.append(stack.peek());
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}