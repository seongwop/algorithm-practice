class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) n * 1000000000L;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (checkPossible(mid, n, times)) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return answer;
    }
    
    boolean checkPossible(long mid, int n, int[] times) {
        long count = 0;
        for (int time : times) {
            count += mid / time;
            if (count >= n) return true;
        }
        return false;
    }
}


