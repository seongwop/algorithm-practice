import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        StringBuilder sb = new StringBuilder(s);

        Stack<Character> stack = new Stack<>();

        int stackSize = 0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(c);
                stackSize++;
            } else if (c == ')') {
                if (stackSize == 0) {
                    answer = false;
                    break;
                }
                stack.pop();
                stackSize--;
            }
        }

        if (stackSize != 0) {
            answer = false;
        }

        return answer;
    }
}
