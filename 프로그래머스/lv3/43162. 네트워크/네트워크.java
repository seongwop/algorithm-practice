class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int index, int n, int[][] computers) {
        visited[index] = true;
        for (int i = 0; i < n; i++) {
            if(index != i && computers[index][i] == 1 && visited[i] == false) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}