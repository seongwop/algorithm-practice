import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int last = routes[0][1];
        int count = 1;
        
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > last) {
                count++;
                last = routes[i][1];
            } else {
                last = Math.min(routes[i][1], last);
            }
        }
        return count;
    }
}