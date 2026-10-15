import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        String[][] splitFile = new String[files.length][3];
        int idx = 0;
        for (String file : files) {
            String Head = "";
            int charIdx = 0;
            while (charIdx < file.length() && (file.charAt(charIdx) < '0' || file.charAt(charIdx) > '9')) {
                Head += file.charAt(charIdx);
                charIdx++;
            }
            String Num = "";
            while (charIdx < file.length() && file.charAt(charIdx) >= '0' && file.charAt(charIdx) <= '9') {
                Num += file.charAt(charIdx);
                charIdx++;
                if (Num.length() == 5) break;
            }
            String Tail = "";
            while (charIdx < file.length()) {
                Tail += file.charAt(charIdx);
                charIdx++;
            }
            splitFile[idx++] = new String[]{Head, Num, Tail};
        }
        
        Arrays.sort(splitFile, (a, b) -> {
            int sortHead = a[0].toLowerCase().compareTo(b[0].toLowerCase());
            int sortNum = Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            if (sortHead != 0) {
                return sortHead;
            } else if (sortNum != 0) {
                return sortNum;
            }
            return 0;
        });
        
        String[] result = new String[splitFile.length];
        int idx2 = 0;
        for (String[] s : splitFile) {
            result[idx2] = s[0] + s[1] + s[2];
            idx2++;
        }
        
        return result;
    }
}