class Solution {
    public int solution(int[] money) {
        int n = money.length;
        // DP 문제
        // i번째 집을 털지 구분하는 기준
        // 점화식: dp[i] = max(dp[i - 1], dp[i - 2] + money[i])
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        // 첫 집을 턴 경우
        dp1[0] = money[0];
        dp1[1] = money[0];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }
        
        // 두번째 집을 턴 경우
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }
        
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}