import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // LIFO 구조
        Queue<Integer> bridge = new ArrayDeque<>();
        int totalWeight = 0;
        int totalTime = 0;
        int idx = 0;
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        while (idx < truck_weights.length) {
            if (weight - totalWeight < truck_weights[idx]) {
                totalWeight -= bridge.poll();
                totalTime++;
                if (weight - totalWeight >= truck_weights[idx]) {
                    bridge.offer(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                } else {
                    bridge.offer(0);
                }
            } else {
                totalWeight -= bridge.poll();
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                totalTime++;
                idx++;
            }
        }
        totalTime += bridge_length;
        return totalTime;
    }
}