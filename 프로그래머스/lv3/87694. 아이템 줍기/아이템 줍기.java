import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
        for (int[] rec: rectangle) {
            for (int i = rec[0] * 2; i <= rec[2] * 2; i++) {
                for (int j = rec[1] * 2; j <= rec[3] * 2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int[] rec: rectangle) {
            for (int i = rec[0] * 2 + 1; i <= rec[2] * 2 - 1; i++) {
                for (int j = rec[1] * 2 + 1; j <= rec[3] * 2 - 1; j++) {
                    map[i][j] = 0;
                }
            }
        }
        answer = bfs(map, characterX, characterY, itemX, itemY) / 2;
        return answer;
    }
    
    public int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{characterX * 2, characterY * 2});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cnt = map[current[0]][current[1]];
            for (int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];
                if (map[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    map[x][y] = cnt+ + 1;
                }
            }
        }
        return map[itemX * 2][itemY * 2];
    }
}