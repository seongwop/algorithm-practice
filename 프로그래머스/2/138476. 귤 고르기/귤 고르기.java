import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 정렬 후 개수가 적은 귤 종류부터 k가 될 때까지 제거 후 남은 종류의 수
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        int amount = 0;
        for (int i : list) {
            amount += i;
            answer++;
            if (amount >= k) {
                break;
            }
        }
        return answer;
    }
}