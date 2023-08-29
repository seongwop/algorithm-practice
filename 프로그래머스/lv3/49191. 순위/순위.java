class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] game = new int[n][n];
        // Floyd-Warshall Algorithm
        for (int[] result : results) {
            game[result[0] - 1][result[1] - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (game[j][k] == 0 && game [j][i] == 1 && game[i][k] == 1)
                        game[j][k] = 1;
                }
            }
        }
        
        int[] count = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j] == 1) count[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[j][i] == 1) count[i]++;
            }
        }
        
        for (int cnt : count) {
            if (cnt == n - 1) answer++;
        }
        return answer;
    }
}