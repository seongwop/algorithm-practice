import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!hashMap.containsKey(clothes[i][1])) {
                hashMap.put(clothes[i][1], 1);
            } else {
                int value = hashMap.get(clothes[i][1]);
                hashMap.put(clothes[i][1], value + 1);
            }
        }

        for (String key : hashMap.keySet()) {
            answer *= hashMap.get(key) + 1;
        }
        answer--;
        
        return answer;
    }
}