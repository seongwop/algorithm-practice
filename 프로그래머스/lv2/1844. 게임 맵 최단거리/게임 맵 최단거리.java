import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        
        answer = bfs(maps, visited, queue);
        
        if (answer == 0)
            answer = -1;
   
        return answer;
    }
    
    int bfs(int[][] maps, int[][] visited, Queue<int[]> queue) {
        int x = 0, y = 0;
        int low = maps.length;
        int col = maps[0].length;
        int cur = 0;

        queue.offer(new int[]{x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int cx = loc[0];
            int cy = loc[1];
            cur = visited[cx][cy];
            for (int i = 0; i < 4; i++) {
                x = cx + dx[i];
                y = cy + dy[i];
                if (x >= 0 && x < low && y >= 0 && y < col && maps[x][y] == 1 && visited[x][y] == 0) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = cur + 1;
                }
            }
        }
        return visited[low - 1][col - 1];
    }
}