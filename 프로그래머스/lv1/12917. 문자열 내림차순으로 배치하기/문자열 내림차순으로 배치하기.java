import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 입력 문자열을 Character로 변환하여 ArrayList에 추가
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) characterList.add(c);

        // 역순으로 정렬
        Collections.sort(characterList, Collections.reverseOrder());

        String answer = "";
        for (Character chr : characterList) answer += chr;
        
        return answer;
    }
}