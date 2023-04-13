import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        // 문자열을 캐릭터 배열로 쪼갬
        char[] charArray = dartResult.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            // 점수가 10일 경우 1, 0 과 보너스까지 계산해서 리스트에 추가
            if (charArray[i] == '1' && charArray[i + 1] == '0') {
                list.add(calculate(10, charArray[i + 2]));
                i += 2;
            // 캐릭터가 숫자일 경우
            } else if (charArray[i] >= 48 && charArray[i] <= 57) {
                list.add(calculate(charArray[i] - '0', charArray[i + 1]));
                i += 1;
            // 캐릭터가 옵션일 경우
            }  else if (charArray[i] == '*') {
                if (list.size() < 2) {
                    list.set(0, list.get(0) * 2);
                } else {
                    for (int j = list.size() - 2; j < list.size(); j++) {
                    list.set(j, list.get(j) * 2);
                    }
                }
            } else if (charArray[i] == '#') {
                list.set(list.size() - 1, list.get(list.size() - 1) * (-1));
            }
        }
        for (Integer item : list) {
            answer += item;
        }
        return answer;
    }
    
    // 점수와 보너스가 주어지면 계산해서 반환
    public int calculate(int num, char ch) {
        if (ch == 'S') return (int)Math.pow(num, 1);
        else if (ch == 'D') return (int)Math.pow(num, 2);
        else return (int)Math.pow(num, 3);
    }
}