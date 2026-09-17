import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int count = 0;
        int lastPoint = -30001;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] route : routes) {
            if (lastPoint >= route[0] && lastPoint <= route[1]) {
                continue;
            } else {
                lastPoint = route[1];
                count++;
            }
        }
        return count;
    }
}