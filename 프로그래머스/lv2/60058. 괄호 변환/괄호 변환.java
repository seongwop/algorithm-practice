import java.util.*;

class Solution {
    public String solution(String p) {
    
        return convert(p);
    }
    
    String convert(String p) {
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        if (p.isEmpty()) return p;
        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
        String[] splitArr = split(p);
        String u = splitArr[0];
        String v = splitArr[1];
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        if (isCorrect(u)) {
            v = convert(v);
            //3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
            return u + v;
        //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
        } else {
            //4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
            String str = "(";
            //4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
            str += convert(v);
            //4-3. ')'를 다시 붙입니다. 
            str += ")";
            //4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
            for (int i = 0; i < u.length(); i++) {
                if (i == 0 || i == u.length() - 1) continue;
                if (u.charAt(i) == '(') str += ")";
                else str += "(";
            }
            //4-5. 생성된 문자열을 반환합니다.
            return str;
        }
        
    }
    
    String[] split(String w) {
        int leftCnt = 0;
        int rightCnt = 0;
        int index = 0;
        for (char c : w.toCharArray()) {
            if (c == '(') leftCnt++;
            else rightCnt++;
            index++;
            if (leftCnt == rightCnt) {
                return new String[]{w.substring(0, index), w.substring(index, w.length())};
            }
        }
        
        return new String[]{};
    }
    
    boolean isCorrect(String u) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : u.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}