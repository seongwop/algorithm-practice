import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    int[][] route = new int[102][102];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 2 * rectangle[i][0]; j <= 2 * rectangle[i][2]; j++) {
                for (int k = 2 * rectangle[i][1]; k <= 2 * rectangle[i][3]; k++) {
                    route[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 2 * rectangle[i][0] + 1; j <= 2 * rectangle[i][2] - 1; j++) {
                for (int k = 2 * rectangle[i][1] + 1; k <= 2 * rectangle[i][3] - 1; k++) {
                    route[j][k] = 0;
                }
            }
        }
        bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
        return route[2 * itemX][2 * itemY] / 2;
    }
    
    void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY});
        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            int x = dir[0];
            int y = dir[1];
            int cur = route[x][y];
            route[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                if (route[x + dx[i]][y + dy[i]] != 0) {
                    if (x + dx[i] == itemX && y + dy[i] == itemY) {
                        if (route[x + dx[i]][y + dy[i]] == 1) {
                            route[x + dx[i]][y + dy[i]] = cur + 1;
                        } else {
                            route[x + dx[i]][y + dy[i]] = Math.min(route[x + dx[i]][y + dy[i]], cur + 1);
                        }
                        break;
                    }
                    queue.offer(new int[]{x + dx[i], y + dy[i]});
                    route[x + dx[i]][y + dy[i]] = cur + 1;
                }
            }
        }
    }
}