import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque<Integer> queue = new ArrayDeque<>(arr.length);
        for (int i : arr) if (queue.isEmpty() || queue.peekLast() != i) queue.add(i);
        answer = queue.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}