import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (visited[i][j] || picture[i][j] == 0) continue;
                queue.offer(new int[]{i, j});
                visited[i][j] = true;
                int count = 0;
                while (!queue.isEmpty()) {
                    int[] curLoc = queue.poll();
                    int color = picture[curLoc[0]][curLoc[1]];
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int r = curLoc[0] + dr[k];
                        int c = curLoc[1] + dc[k];
                        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || picture[r][c] != color) continue;
                        visited[r][c] = true;
                        queue.offer(new int[]{r, c});
                    }
                }
                numberOfArea++;
                if (count > maxSizeOfOneArea) {
                    maxSizeOfOneArea = count;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    
}