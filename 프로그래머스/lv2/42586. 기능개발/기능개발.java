import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        
        while (!queue.isEmpty()) {
            int min = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && min >= queue.peek()) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}