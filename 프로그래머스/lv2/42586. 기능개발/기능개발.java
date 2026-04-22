import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        int firstDay = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        stack.push(firstDay);
        int cnt = 1;

        for (int i = 1; i < progresses.length; i++) {
            int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            
            if (stack.peek() >= days) {
                cnt++;
            } else {
                al.add(cnt);
                cnt = 1;
                stack.pop();
                stack.push(days);
            }
        }
        al.add(cnt);

        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}