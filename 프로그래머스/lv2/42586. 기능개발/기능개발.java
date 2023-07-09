import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Queue에 완성일 전부 넣기
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        
        // Queue가 빌 때까지
        while (!queue.isEmpty()) {
            int min = queue.poll();
            int count = 1;
            // 처음 꺼낸 값이 가장 크거나 같을 동안 Queue에서 계속 꺼내면서 개수 카운트
            while(!queue.isEmpty() && min >= queue.peek()) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}