import java.util.*;

class Solution {
    public int solution(String s) {
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 1; i <= s.length(); i++) {
            int len = s.length();
            int left = 0;
            int num = 0;
            String lastString = "";
            while (left + i <= s.length()) {
                String str = s.substring(left, left + i);
                if (str.equals(lastString)) {
                    num++;
                // 연속이 끊길 때 길이 갱신
                } else if (num != 0) {
                    len = len - num * i + String.valueOf(num + 1).length();
                    num = 0;
                }
                lastString = str;
                left += i;
            }
            // 마지막에 남은 연속된 문자열 갱신
            if (num != 0) {
                len = len - num * i + String.valueOf(num + 1).length();
            }
            
            if (minLen > len) {
                minLen = len;
            }
        }     
        return minLen;
    }
}