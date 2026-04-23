import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        if (s.charAt(0) == ')') return false;
        else stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        if (stack.size() == 0) return true;
        else return false;
    }
}