import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int count =0, idx = 0, range = 0, total = 0;
        
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= range) {
                pq.offer(jobs[idx++]);
            }
            if (pq.isEmpty()) {
                range = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                range += job[1];
                total += range - job[0];
                count++;
            }
        }
        return total / jobs.length;
    }
}