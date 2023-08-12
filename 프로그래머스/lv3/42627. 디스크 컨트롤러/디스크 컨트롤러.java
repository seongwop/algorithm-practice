import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 요청 시점이 같을 경우 작업의 시간 순으로 정렬
        // 해당 방법 외에 모든 요청을 큐에 넣는 방법 또한 존재
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; 
            } else {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int index = 0;
        int end = 0;
        int count = 0;
        int result = 0;

        while (count < jobs.length) {
            if (pq.isEmpty()) {
                result += jobs[index][1];
                end = jobs[index][0] + jobs[index][1];
                index++;
                count++;
            } else {
                int[] job = pq.poll();
                result += end - job[0] + job[1];
                end += job[1];
                count++;
            }
            // 이전 작업의 수행 도중 들어온 요청 중 가장 짧은 요청 수행
            while (index < jobs.length && jobs[index][0] < end) {
                pq.offer(jobs[index]);
                index++;
            }
        }
        answer = (int) Math.floor((double)result / jobs.length);
        
        return answer;
    }
}