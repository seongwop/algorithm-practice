import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // 최적화 포인트
        // 1. 처음부터 배열에 -1을 넣어서 굳이 스택에 남은 값을 빼는 작업 스킵
        // 2. 값은 배열에 있으니 객체 대신 인덱스만 스택에
        
        // 가장 먼저 나오는 더 큰값
        // 스택
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                // 스택의 맨 위 값이 더 작을 경우 기록
                if (numbers[stack.peek()] < numbers[i]) {
                    result[stack.pop()] = numbers[i];
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        return result;
    }

}