import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        // 점화식
        // dp[y]는 y까지 연산하는 과정의 최소 연산 횟수
        int[] dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        while (!queue.isEmpty()) {
            int curX = queue.poll();
            if (curX + n <= y && dp[curX + n] > dp[curX] + 1) {
                dp[curX + n] = dp[curX] + 1;
                queue.offer(curX + n);
            } 
            if (curX * 2 <= y && dp[curX * 2] > dp[curX] + 1) {
                dp[curX * 2] = dp[curX] + 1;
                queue.offer(curX * 2);
            } 
            if (curX * 3 <= y && dp[curX * 3] > dp[curX] + 1) {
                dp[curX * 3] = dp[curX] + 1;
                queue.offer(curX * 3);
            } 
        }
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}