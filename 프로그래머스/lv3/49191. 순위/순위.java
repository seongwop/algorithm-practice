import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] winList = new boolean[n + 1][n + 1];
        
        // 인접리스트
        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for(int[] result : results) {
            lists[result[0]].add(result[1]);
        }
        for (int i = 1; i <= n; i++) {
            dfs(winList, lists, i, i);
        }
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                
                if (winList[i][j] || winList[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            } 
        } 
        return answer;
    }
    
    void dfs(boolean[][] winList, List<Integer>[] lists, int start, int next) {
        for (int i : lists[next]) {
            if (!winList[start][i]) {
                winList[start][i] = true;
                dfs(winList, lists, start, i);
            }
        }
    }
}