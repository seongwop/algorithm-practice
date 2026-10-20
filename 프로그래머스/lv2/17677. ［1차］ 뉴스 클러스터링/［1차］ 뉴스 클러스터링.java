import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = convertToMap(str1);
        Map<String, Integer> map2 = convertToMap(str2);
        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }
        
        answer = (int) (((double) getIntersectionSize(map1, map2) / (double) getUnionSize(map1, map2)) * 65536);
        
        return answer;
    }
    
    Map<String, Integer> convertToMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length(); i++) {
            char fa = str.charAt(i - 1);
            char sa = str.charAt(i);
            if (fa < 'a' || fa > 'z' || sa < 'a' || sa > 'z') continue;
            String string = String.valueOf(fa) + sa;
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        return map;
    }
    
    int getIntersectionSize(Map<String, Integer> A, Map<String, Integer> B) {
        int size = 0;
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                size += Math.min(A.get(key), B.get(key));
            }
        }
        return size;
    }
    
    int getUnionSize(Map<String, Integer> A, Map<String, Integer> B) {
        int size = 0;
        for (String key : A.keySet()) {
            if (B.containsKey(key)) {
                size += Math.max(A.get(key), B.get(key));
            } else {
                size += A.get(key);
            }
        }
        
        for (String key : B.keySet()) {
            if (!A.containsKey(key)) {
                size += B.get(key);
            }
        }
        return size;
    }
}