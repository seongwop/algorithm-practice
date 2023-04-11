import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1단계
        new_id = new_id.toLowerCase();
        char[] chars = new_id.toCharArray();
        List<Character> charList = new ArrayList<>();
        
        // 2단계 - ArrayList에 조건에 부합하는 Character 넣기
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 48 && chars[i] <= 57) || (chars[i] >= 97 && chars[i] <= 122) || chars[i] == '-' || chars[i] == '_' || chars[i] == '.')
                charList.add(chars[i]);
        }
        // 3단계 - '.' 이 연속된다면 하나 삭제하고 인덱스 1 감소
        for (int i = 1; i < charList.size(); i++) {
            if (charList.get(i) == '.' && charList.get(i - 1) == '.') {
                charList.remove(i);
                i--;
            }
        }
        // 4단계
        if (charList.get(0) == '.') charList.remove(0);
        if (!charList.isEmpty() && charList.get(charList.size() - 1) == '.') charList.remove(charList.size() - 1);
        // 5단계
        if (charList.isEmpty()) charList.add('a');
        // 6단계
        for (int i = 0; i < charList.size(); i++) if (i > 14) charList.remove(i--);
        if (charList.get(charList.size() - 1) == '.') charList.remove(charList.size() - 1);
        // 7단계
        if (charList.size() <= 2) while (charList.size() < 3) charList.add(charList.get(charList.size() - 1));
        for (Character c : charList) answer += c;
        
        return answer;
    }
}