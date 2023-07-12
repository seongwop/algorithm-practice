import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int cnt = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(scoville.length);

        for (int i : scoville) priorityQueue.add(i);

        while (priorityQueue.size() >= 2) {
            // 첫 음식이 조건을 만족하는 경우 break
            if (priorityQueue.peek() >= K) break;
            int score = priorityQueue.poll() + priorityQueue.poll() * 2;
            cnt++;
            priorityQueue.add(score);
        }
        // 음식이 한 개거나 다 섞은 후에도 스코빌 지수가 K보다 낮을 경우 -1 리턴
        if (priorityQueue.peek() < K) return -1;
        return cnt;
    }
}