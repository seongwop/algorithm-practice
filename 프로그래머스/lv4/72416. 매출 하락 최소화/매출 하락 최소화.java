import java.util.*;

class Solution {
    public int solution(int[] sales, int[][] links) {
        // 부모가 불참: 자식들의 최솟값을 더하되 전부 불참일 경우 불참 -> 참 으로 변경 비용이 최소인 자식을 변경
        // 부모가 참: 자식들의 최솟값
        
        List<Integer>[] children = new ArrayList[sales.length + 1];
        for (int i = 0; i <= sales.length; i++) {
            children[i] = new ArrayList<>();
        }
        for (int[] link : links) {
            children[link[0]].add(link[1]);
        }
        int[][] dp = new int[sales.length + 1][2];
        dfs(1, sales, children, dp); 
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    void dfs(int parent, int[] sales, List<Integer>[] children, int[][] dp) {
        dp[parent][0] = 0;
        dp[parent][1] = sales[parent - 1];
        
        // 맨아래 리프노드까지 탐색
        for (int child : children[parent]) {
            dfs(child, sales, children, dp);
        }
        // 맨아래 리프노드부터 역으로 dp 갱신
        boolean hasAttendingChild = false;
        
        for (int child : children[parent]) {
            int absent = dp[child][0];
            int attend = dp[child][1];
            // 부모가 불참 시
            dp[parent][0] += Math.min(absent, attend);
            // 부모가 참여 시
            dp[parent][1] += Math.min(absent, attend);
            
            if (attend <= absent) {
                hasAttendingChild = true;
            }
        }
        
        // 부모가 불참인데 자식도 전부 불참일 경우 변경비용이 최솟값을 더함
        if (!hasAttendingChild && !children[parent].isEmpty()) {
            int minChangeCost = Integer.MAX_VALUE;
            for (int child : children[parent]) {
                int absent = dp[child][0];
                int attend = dp[child][1];
                minChangeCost = Math.min(minChangeCost, attend - absent);
            }
            dp[parent][0] += minChangeCost;
        }
    }
}