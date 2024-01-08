import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    if (set.contains(num)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }

        }

        System.out.println(sb);
    }
}