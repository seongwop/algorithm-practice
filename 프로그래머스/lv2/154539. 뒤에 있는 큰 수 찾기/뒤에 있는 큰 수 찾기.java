import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        // 가장 먼저 나오는 더 큰값
        // 스택
        int[] result = new int[numbers.length];
        Deque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                // 스택의 맨 위 값이 더 작을 경우 기록
                if (stack.peek().num < numbers[i]) {
                    Node node = stack.pop();
                    result[node.idx] = numbers[i];
                } else {
                    break;
                }
            }
            stack.push(new Node(i, numbers[i]));
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result[node.idx] = -1;
        }
        return result;
    }
    
    static class Node {
        int idx;
        int num;
        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}