import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int N, Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph.get(p).add(new Node(q, r));
            graph.get(q).add(new Node(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(bfs(k, v));
        }
    }

    static int bfs(int k, int v) {
        int cnt = 0;
        Queue<Integer> pq = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[v] = true;
        pq.add(v);
        while (!pq.isEmpty()) {
            int n = pq.poll();
            for (int i = 0; i < graph.get(n).size(); i++) {
                int next = graph.get(n).get(i).next;
                int weight = graph.get(n).get(i).weight;
                if (visited[next] || weight < k) continue;
                pq.add(next);
                visited[next] = true;
                cnt++;
            }
        }
        return cnt;
    }

    static class Node {
        int next, weight;
        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
}