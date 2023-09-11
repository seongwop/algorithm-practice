class Solution {
    public int solution(String arr[]) {
        int[][] max_dp, min_dp;
        int operandCnt = arr.length / 2 + 1;
        max_dp = new int[operandCnt][operandCnt];
        min_dp = new int[operandCnt][operandCnt];
        for (int i = 0; i < operandCnt; i++) {
            for (int j = 0; j < operandCnt; j++) {
                max_dp[i][j] = Integer.MIN_VALUE;
                min_dp[i][j] = Integer.MAX_VALUE;
            }
            max_dp[i][i] = Integer.parseInt(arr[i * 2]);
            min_dp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int operatorCnt = 1; operatorCnt < operandCnt; operatorCnt++) {
            for (int i = 0; i < operandCnt - operatorCnt; i++) {
                int j = i + operatorCnt;
                for (int k = i; k < j; k++) {
                    if (arr[k * 2 + 1].equals("+")) {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k + 1][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k + 1][j]);
                    }
                }
            }
        }
        return max_dp[0][operandCnt - 1];
    }
}