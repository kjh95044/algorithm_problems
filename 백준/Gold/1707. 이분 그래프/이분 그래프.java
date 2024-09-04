import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> adj;
    static int[] colors;
    static final int RED = -1, BLUE = 1;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int V, E;


        while(T--> 0){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            colors = new int[V+1];
            adj = new ArrayList<>();
            for(int j=0; j<V+1; j++){
                adj.add(new ArrayList<>());
            }

            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());

                adj.get(e1).add(e2);
                adj.get(e2).add(e1);
            }

            boolean isBipartite = true;

            for (int i = 1; i < V + 1; i++) {
                if(colors[i] ==0 && !IsBipartiteGraph(i)) {
                    isBipartite = false;
                    break;
                }
            }

            if(isBipartite){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }

        }

        System.out.println(sb);

    }

    private static boolean IsBipartiteGraph(int startV) {
        Queue<Integer> q = new LinkedList<>();

        q.add(startV);
        colors[startV] = RED;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int v: adj.get(cur)){
                if(colors[v] == 0){
                    colors[v] = colors[cur] * -1;
                    q.add(v);
                } else if(colors[v] != colors[cur] * -1){
                    return false;
                }
            }
        }
        return true;
    }


}