class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m][n];
        for (int[] puddle : puddles) map[puddle[0] - 1][puddle[1] - 1] = -1;
        for (int i = 0; i < m; i++) {
            if (map[i][0] == -1) break;
            map[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (map[0][i] == -1) break;
            map[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == -1) continue;
                if (map[i - 1][j] == -1 && map[i][j - 1] == -1) continue;
                if (map[i - 1][j] == -1) {
                    map[i][j] = map[i][j - 1];
                    continue;
                } else if (map[i][j - 1] == -1) {
                    map[i][j] = map[i - 1][j];
                    continue;
                }
                map[i][j] = (map[i - 1][j] + map[i][j - 1])  % 1000000007;
            }
        }
        answer = map[m - 1][n - 1] % 1000000007;
        return answer;
    }
}