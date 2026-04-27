import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new Process(priorities[i], i));
        }
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            if (process.priority < pq.peek()) {
                queue.add(process);
            }
            else {
                pq.poll();
                answer++;
                if (process.index == location) {
                    return answer; 
                }
            }
        }
        return answer;
    }
}

class Process {
    int priority;
    int index;
    Process(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}