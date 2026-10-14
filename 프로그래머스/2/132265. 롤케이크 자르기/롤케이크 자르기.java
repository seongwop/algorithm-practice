import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 해시맵 두개로 각 원소들을 한쪽엔 더하고 한쪽엔 빼면서 진행
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        // 한쪽에 먼저 전부 저장
        for (int i : topping) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        // 원소 하나씩 한쪽에서 빼고 한쪽에서 더하며 양 맵의 사이즈가 같을 때 +1
        for (int i : topping) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
            map2.put(i, map2.get(i) - 1);
            if (map2.get(i) == 0) {
                map2.remove(i);
            }
            if (map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}