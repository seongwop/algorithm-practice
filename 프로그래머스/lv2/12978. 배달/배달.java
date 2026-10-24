import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 인접리스트
        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        answer = getDeliveryCount(N, graph, K);
        return answer;
    } 
    
    int getDeliveryCount(int N, List<Node>[] graph, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.vertex] < cur.distance) continue;
            for (Node next : graph[cur.vertex]) {
                if (dist[cur.vertex] + next.distance > K || dist[next.vertex] <= dist[cur.vertex] + next.distance) continue;
                dist[next.vertex] = dist[cur.vertex] + next.distance;
                pq.offer(next);
            }
        }
        // 방문한 마을 개수 세기
        int cnt = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                cnt++;
            }
        }
        return cnt;
    }
    
    static class Node {
        int vertex;
        int distance;
        
        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}