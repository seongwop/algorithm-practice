import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> recordMap = new HashMap<>();
        int resultNum = 0;
        for (String rec : record) {
            String[] s = rec.split(" ");
            if (s[0].equals("Enter")) {
                recordMap.put(s[1], s[2]);
                resultNum++;
            } else if (s[0].equals("Change")) {
                recordMap.put(s[1], s[2]);
            } else {
                resultNum++;
            }
        }
        
        String[] result = new String[resultNum];
        int idx = 0;
        for (String s : record) {
            String[] arr = s.split(" ");
            if (arr[0].equals("Enter")) {
                result[idx++] = recordMap.get(arr[1]) + "님이 들어왔습니다.";
            } else if (arr[0].equals("Leave")) {
                result[idx++] = recordMap.get(arr[1]) + "님이 나갔습니다.";
            } 
        }
        return result;
    }
}