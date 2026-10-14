import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        
        // 인접리스트 생성
        List<Node>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            list[path[0]].add(new Node(path[1], path[2]));
            list[path[1]].add(new Node(path[0], path[2]));
        }
        
        int[] dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        int[] loc = new int[n + 1];
        for (int gate : gates) {
            dist[gate] = 0;
            loc[gate] = -1;
        }
        for (int summit : summits) {
            loc[summit] = -2;
        }
        
        int minIntensity = 0;
        
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for (int gate : gates) {
            queue.offer(new Node(gate, 0));
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 큐에서 꺼낸 값이 최소보다 클 경우 스킵
            if (dist[cur.vertex] < cur.cost) continue;
            // 산봉우리면 종료
            if (loc[cur.vertex] == -2) continue;
            for (Node next : list[cur.vertex]) {
                // 출발지면 스킵
                if (loc[next.vertex] == -1) continue;
                // 지금까지 온 간선 중 최대값
                int newIntensity = Math.max(dist[cur.vertex], next.cost);
                // 해당 최대값이 기존보다 작을때 최소가 되므로 갱신
                if (dist[next.vertex] > newIntensity) {
                    dist[next.vertex] = newIntensity;
                    queue.offer(new Node(next.vertex, dist[next.vertex]));                        
                }
            }
        }
        
        Arrays.sort(summits);
        int min = Integer.MAX_VALUE;
        for (int summit : summits) {
            min = Math.min(dist[summit], min);
        }
        int summitNum = 0;
        for (int summit : summits) {
            if (dist[summit] == min) {
                summitNum = summit;
                break;
            }
        }
        return new int[]{summitNum, min};
    }
    
    static class Node {
        int vertex;
        int cost;
        public Node (int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}