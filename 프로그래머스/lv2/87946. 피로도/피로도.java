class Solution {
    
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k, visited);
        return max;
    }
    
    void dfs(int[][] dungeons, int count, int currentK, boolean[] visited) {
        max = Math.max(max, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (currentK >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, count + 1, currentK - dungeons[i][1], visited);
                visited[i] = false;
            } 
        }
    }
}