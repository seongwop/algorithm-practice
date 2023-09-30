import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.offer(work);
        }
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty() || pq.peek() == 0) {
                return 0;
            } else {
                pq.offer(pq.poll() - 1);
            }
        }
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}