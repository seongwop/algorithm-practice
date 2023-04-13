import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        char[] charArray = dartResult.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1' && charArray[i + 1] == '0') {
                list.add(calculate(10, charArray[i + 2]));
                i += 2;
            } else if (charArray[i] >= 48 && charArray[i] <= 57) {
                list.add(calculate(charArray[i] - '0', charArray[i + 1]));
                i += 1;
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

    
    public int calculate(int num, char ch) {
        if (ch == 'S') return (int)Math.pow(num, 1);
        else if (ch == 'D') return (int)Math.pow(num, 2);
        else return (int)Math.pow(num, 3);
    }
}