import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N,M;

        for(int i=0; i<T; i++){
            Queue<Integer[]> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int result = 0;


            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Integer[]{j, priority});
            }
            while(!queue.isEmpty()){
                int queueSize = queue.size();
                Integer[] val = queue.poll();
                Queue<Integer[]> tempQueue = new ArrayDeque<>(queue);

                while (!tempQueue.isEmpty()){
                    Integer[] tempVal = tempQueue.poll();
                    if(val[1] < tempVal[1]){
                        queue.offer(val);
                        break;
                    }
                }


                if(queueSize != queue.size()){
                    result++;
                    if(val[0] == M) {
                        System.out.println(result);
                        break;
                    }
                }
            }
        }

    }

}