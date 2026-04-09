class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int next, int n, int[][] computers, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (i == next) continue;
            if (!visited[i] && computers[next][i] == 1) {
                visited[i] = true;
                dfs(i, n, computers, visited);
            }
        }
    }
}