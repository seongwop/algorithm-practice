import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        // A에서 시작하는 최단거리 배열 = 각 노드에서 A로 가는 최단거리
        // B에서 시작하는 최단거리 배열 = 각 노드에서 B로 가는 최단거리
        // S에서 시작하는 최단거리 배열 = 각 노드로 가는 최단거리
        // 각 노드로의 최단거리 + 해당 노드에서 A로 가는 최단거리 + 해당 노드에서 B로 가는 최단거리 의 최솟값
        
        int[] distanceA = new int[n + 1];
        int[] distanceB = new int[n + 1];
        int[] distanceS = new int[n + 1];
        
        Arrays.fill(distanceA, Integer.MAX_VALUE);
        distanceA[a] = 0;
        Arrays.fill(distanceB, Integer.MAX_VALUE);
        distanceB[b] = 0;
        Arrays.fill(distanceS, Integer.MAX_VALUE);
        distanceS[s] = 0;
        
        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            graph[fare[0]].add(new Node(fare[1], fare[2]));
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        dijkstra(n, s, fares, graph, distanceS);
        dijkstra(n, a, fares, graph, distanceA);
        dijkstra(n, b, fares, graph, distanceB);
        
        for (int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, distanceS[i] + distanceA[i] + distanceB[i]);
        }
        
        return answer;
    }
    
    public void dijkstra(int n, int start, int[][] fares, List<Node>[] graph, int[] distance) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (curNode.cost > distance[curNode.vertex]) continue;
            
            for (Node nextNode : graph[curNode.vertex]) {
                if (distance[nextNode.vertex] > curNode.cost + nextNode.cost) {
                    distance[nextNode.vertex] = curNode.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.vertex, distance[nextNode.vertex]));
                }
            }
        }
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