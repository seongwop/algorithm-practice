import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> indexDeque = new ArrayDeque<>();
        indexDeque.offerLast(0);
        
        for (int i = 1; i < prices.length; i++) {
            while (!indexDeque.isEmpty()) {
                if (prices[i] < prices[indexDeque.peekLast()]) {
                    int index = indexDeque.pollLast();
                    answer[index] = i - index;
                } else {
                    break;
                }
            }
            indexDeque.offerLast(i);
        }
        while (!indexDeque.isEmpty()) {
            int index = indexDeque.pollLast();
            answer[index] = prices.length - 1 - index;
        }
        return answer;
    }
}