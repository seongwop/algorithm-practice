import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main1238 {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        X  = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        distance = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                distance[j] = Integer.MAX_VALUE;
                distance[i] = 0;
                
            }
            int go = dijkstra(i, X);
            for (int j = 1; j <= N; j++) {
                distance[j] = Integer.MAX_VALUE;
                distance[X] = 0;
                
            }
            int back = dijkstra(X, i);
            answer = Math.max(answer, go + back);
        }
        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : graph[cur.vertex]) {
                if (distance[next.vertex] > cur.cost + next.cost) {
                    distance[next.vertex] = cur.cost + next.cost;
                    pq.add(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
        return distance[end];
    }

    static class Node {
        int vertex;
        int cost;
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}