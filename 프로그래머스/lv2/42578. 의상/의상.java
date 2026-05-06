import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] cloth : clothes) {
            if (!hashMap.containsKey(cloth[1])) hashMap.put(cloth[1], 1);
            else hashMap.put(cloth[1], hashMap.get(cloth[1]) + 1);
        }
        for (int i : hashMap.values()) answer *= i + 1;
        return answer - 1;
    }
}