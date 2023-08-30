class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] route = new int[m + 1][n + 1];
        route[1][1] = 1;
        for (int[] puddle : puddles) {
            route[puddle[0]][puddle[1]] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (route[i][j] == -1) {
                    route[i][j] = 0;
                    continue;
                } 
                route[i][j] = (route[i - 1][j] + route[i][j - 1]) % 1000000007;
            }
        }
        return route[m][n];
    }
}