import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N,M,X;
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node node) {
            return Integer.compare(weight, node.weight);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>(); // x에서 시작점들 사이의 최단 거리
        ArrayList<ArrayList<Node>> reversedAdjList = new ArrayList<>(); // 시작점들에서 X 사이의 최단거리

        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<>());
            reversedAdjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adjList.get(start).add(new Node(end, time));
            reversedAdjList.get(end).add(new Node(start, time));
        }

        int[] dist = dijkstra(adjList);
        int[] reversedDist = dijkstra(reversedAdjList);

        int result = 0;

        for(int i=1; i<=N; i++){
            result = Math.max(dist[i] + reversedDist[i], result);
        }

        System.out.println(result);
    }

    static int INF = Integer.MAX_VALUE;

    /* 다익스트라
      1) 아직 방문하지 않은 정점 중 출발지로부터 가장 거리가 짧은 정점을 방문한다.
      2) 해당 정점을 거쳐 갈 수 있는 정점의 거리가 이전 기록한 값보다 적으면 갱신한다.
      3) dist 배열 INF 로 초기화 하기
    */

    private static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(dist, INF);
        dist[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end; // 현재 노드와 연결되어 있는 노드

            if(!visited[cur]){
                visited[cur] = true;

                for(Node node : list.get(cur)){
                    if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist;
    }
}