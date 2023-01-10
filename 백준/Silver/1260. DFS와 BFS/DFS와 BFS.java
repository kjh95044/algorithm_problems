import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main
{
    static int [][] map;
    static int [] visited;
    static int start_v;
    public static void dfs(int v){
        if(start_v == v)
            visited[v] = 1;
        System.out.print(v + " ");
        for(int i=1; i<map.length; i++){
            if(map[v][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = 1;
        while(!queue.isEmpty()){
            int n = queue.poll();
            System.out.print(n + " ");
            for(int i=1; i<map.length; i++){
                if(visited[i]==0 && map[n][i] == 1){
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }

    }


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        start_v = v;
        map = new int[n+1][n+1];
        visited = new int[n+1];

        for(int i=1; i<m+1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(v);
        System.out.println();
        visited = new int[n+1];
        bfs(v);

    }
}