import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> al = new ArrayList<>();
        int max = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        stack.push(max);
        for (int i = 1; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (max < days) {
                al.add(stack.size());
                stack.clear();
                max = days;
            }
            stack.push(days);
        }
        al.add(stack.size());
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}