import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        int truckIndex = 0;
        int totalWeight = 0;
        int time = 0;

        while (true) {
            if (truckIndex == truck_weights.length) break;
            
            if (queue.size() == bridge_length) {
                totalWeight -= queue.poll();
            }
            if (weight - totalWeight >= truck_weights[truckIndex]) {
                queue.offer(truck_weights[truckIndex]);
                totalWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                queue.offer(0); // 더 이상 큐에 들어갈 수 없을 무게일 경우 시간 측정을 위해 0을 넣음
            }
            time++;
        }
        return time + bridge_length;
    }
}