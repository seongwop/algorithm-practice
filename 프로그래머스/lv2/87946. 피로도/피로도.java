class Solution {
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; 
        
        dfs(k, visited, dungeons, 0);
        
        return answer;
    }
    
    void dfs(int k, boolean[] visited, int[][] dungeons, int num) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], visited, dungeons, num + 1);
                visited[i] = false; // return 했을 시 방문 취소
            } 
        }
        if (answer < num)
            answer = num;
    }
}