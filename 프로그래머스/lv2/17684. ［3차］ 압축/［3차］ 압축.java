import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        // 해시맵으로 사전 관리
        Map<String, Integer> dict = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), c - 'A' + 1);
        }
        List<Integer> indexList = new ArrayList<>();
        
        String current = "";
        for (char c : msg.toCharArray()) {
            String next = current + c;
            
            if (dict.containsKey(next)) {
                current = next;
            } else {
                indexList.add(dict.get(current));
                dict.put(next, dict.size() + 1);
                current = String.valueOf(c);
            }
        }
        
        if (!current.isEmpty()) {
            indexList.add(dict.get(current));
        }
        
        return indexList.stream().mapToInt(i -> i).toArray();
    }
}