import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int removedRock = 0;
            int last = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - last < mid) {
                    removedRock++;
                } else {
                    last = rocks[i];
                }
            }
            if (distance - last < mid) 
                removedRock++;
            if (removedRock > n) {
                right = mid - 1;
            } else if (removedRock <= n) {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}