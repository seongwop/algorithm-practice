import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[][] map = new int[n][m];
        map[0][0] = 1;
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int val = map[next[0]][next[1]];
            for (int i = 0; i < 4; i++) {
                int x = next[0] + dx[i];
                int y = next[1] + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] != 0 || maps[x][y] == 0) continue;
                map[x][y] = val + 1;
                queue.add(new int[]{x, y});
            }
        }
        if (map[n - 1][m - 1] == 0) return -1;
        else return map[n - 1][m - 1];
    } 
}