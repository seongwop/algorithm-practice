import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 메인 컨테이너 벨트
        Deque<Integer> main = new ArrayDeque<>();
        // 서브 컨테이너 벨트
        Deque<Integer> sub = new ArrayDeque<>();
        for (int i = order.length; i >= 1; i--) {
            main.push(i);
        }
        
        for (int i : order) {
            boolean check = false;
            // 실어야 하는 상자가 메인 컨테이너 벨트 안쪽에 있을 때
            // 나올때 까지 서브 컨테이너 벨트로 이동
            if (!main.isEmpty() && i > main.peek()) {
                while (!main.isEmpty() && main.peek() < i) {
                    sub.push(main.pop());
                }
            }
            // 기존 컨테이너 벨트에서 꺼낼 수 있을 때
            if (!main.isEmpty() && i == main.peek()) {
                main.pop();
                answer++;
                check = true;
            // 서브 컨테이너 벨트에서 꺼낼 수 있을 때    
            } else if (!sub.isEmpty() && i == sub.peek()) {
                sub.pop();
                answer++;
                check = true;
            }
            if (!check) break;
        }
        
        
        return answer;
    }
}