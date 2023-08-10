import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visited = new int[n + 1];
        visited[1] = 1;
        
        return bfs(edge, visited);
    }
    
    int bfs(int[][] edge, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int max = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int count = visited[num];
            
            for (int i = 0; i < edge.length; i++) {
                if (edge[i][0] == num && visited[edge[i][1]] == 0) {
                    queue.offer(edge[i][1]);
                    visited[edge[i][1]] = count + 1;
                    if (count + 1 > max) max = count + 1;
                } else if (edge[i][1] == num && visited[edge[i][0]] == 0) {
                    queue.offer(edge[i][0]);
                    visited[edge[i][0]] = count + 1;
                    if (count + 1 > max) max = count + 1;
                }
            }
        }
        int result = 0;
        for (int num : visited) {
            if (num == max) {
                result++;
            }
        }
        return result;
    }
}