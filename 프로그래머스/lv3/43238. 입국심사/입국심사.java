import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 0 ~ 최대 시간 이분 탐색
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (long time : times) {
                count += mid / time;
            }
            if (count < n) {
                left = mid + 1;
            } else { 
                right = mid - 1;
                answer = mid; // count == n의 경우가 최소가 아닐 수 있기 때문에 끝까지 탐색
            }
        }
        return answer;
    }
}