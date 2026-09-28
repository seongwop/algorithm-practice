import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 인접리스트
        List<Integer>[] route = new ArrayList[n + 1];
        for (int i = 0; i < route.length; i++) {
            route[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            route[e[0]].add(e[1]);
            route[e[1]].add(e[0]);
        }
        int[] list = new int[n + 1];
        bfs(n, list, route, edge);
        int max = 0;
        for (int distance : list) {
            max = Math.max(max, distance);
        }
        
        for (int distance : list) {
            if (distance == max) {
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(int n, int[] list, List<Integer>[] route, int[][] edge) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(new Node(1, 0));
        visited[1] = true;
        list[1] = 0;
        while (!queue.isEmpty()) {
            Node vertex = queue.poll();

            for (int next : route[vertex.num]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, vertex.distance + 1));
                    list[next] = vertex.distance + 1;
                }
            }
        }
    }
}

class Node {
    int num;
    int distance;
    
    public Node(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }
} 