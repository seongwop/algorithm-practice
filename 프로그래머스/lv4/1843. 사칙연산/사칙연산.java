import java.util.Arrays;

class Solution {
    public int solution(String arr[]) {
        
        int n = arr.length / 2 + 1;
        int[] nums = new int[n];
        char[] ops = new char[n - 1];
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i].charAt(0);
            }
        }
        
        int[][] minDp = new int[n][n];
        int[][] maxDp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE / 2);
            Arrays.fill(minDp[i], Integer.MAX_VALUE / 2);
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                // 끝 인덱스
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    if (ops[k] == '+') {
                        // 덧셈: (최대 + 최대)가 최대, (최소 + 최소)가 최소
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);
                    } else if (ops[k] == '-') {
                        // 뺄셈: (최대 - 최소)가 최대, (최소 - 최대)가 최소
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k + 1][j]);
                    }
                }
            }
        }
        
        return maxDp[0][n - 1];
    }
}