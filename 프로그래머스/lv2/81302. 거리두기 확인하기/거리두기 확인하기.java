import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < places.length; i++) {
            if (bfs(places[i]) == true) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    boolean bfs(String[] place) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    boolean[][] visited = new boolean[5][5];
                    visited[i][j] = true;
                    Queue<Node> queue = new ArrayDeque<>();
                    queue.offer(new Node(new int[]{i, j}, 0));
                    while (!queue.isEmpty()) {
                        Node curNode = queue.poll();
                        int curRow = curNode.loc[0];
                        int curCol = curNode.loc[1];
                        
                        if (curNode.depth > 0 && curNode.depth <= 2 && place[curRow].charAt(curCol) == 'P') {
                            return true;
                        } else if (curNode.depth >= 2) {
                            continue;
                        }
                        for (int k = 0; k < 4; k++) {
                            int nextRow = curRow + dr[k];
                            int nextCol = curCol + dc[k];
                            if (nextRow < 0 || nextCol < 0 || nextRow >= 5 || nextCol >= 5 || visited[nextRow][nextCol]) continue;
                            if (place[nextRow].charAt(nextCol) == 'X') continue;
                            visited[nextRow][nextCol] = true;
                            queue.offer(new Node(new int[]{nextRow, nextCol}, curNode.depth + 1));
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static class Node {
        int[] loc;
        int depth;
        public Node(int[] loc, int depth) {
            this.loc = loc;
            this.depth = depth;
        }
    }
}