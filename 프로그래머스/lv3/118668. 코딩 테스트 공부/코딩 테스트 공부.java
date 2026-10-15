class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        // 알고력, 코딩력의 최소 시간 값 저장
        int[][] dp = new int[151][151];
        
        int maxAlp = alp;
        int maxCop = cop;
        for (int[] problem : problems) {
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
        }
        
        for (int i = alp; i < dp.length; i++) {
            for (int j = cop; j < dp[0].length; j++) {
                dp[i][j] = i - alp + j - cop;
            }
        }
        
        for (int i = alp; i < dp.length; i++) {
            for (int j = cop; j < dp[0].length; j++) {
                if (i < dp.length - 1) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                }
                if (j < dp[0].length - 1) {
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1); 
                }
                int curAlp = i;
                int curCop = j;
                for (int[] problem : problems) {
                    int probAlp = problem[0];
                    int probCop = problem[1];
                    int addAlp = problem[2];
                    int addCop = problem[3];
                    int cost = problem[4];
                    if (probAlp <= i && probCop <= j) {
                        int nextAlp = i + addAlp;
                        if (nextAlp > 150) nextAlp = 150;
                        int nextCop = j + addCop;
                        if (nextCop > 150) nextCop = 150;
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }
        answer = dp[maxAlp][maxCop];
        for (int i = maxAlp; i < dp.length; i++) {
            for (int j = maxCop; j < dp[0].length; j++) {
                answer = Math.min(dp[i][j], answer);
            }
        }
        return answer;
    }
}