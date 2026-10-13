import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 해시맵 + 슬라이딩 윈도우
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        // 첫 윈도우 채우기
        for (int i = 0; i < 10; i++) {
            currentMap.put(discount[i], currentMap.getOrDefault(discount[i], 0) + 1);
        }
        if (wantMap.equals(currentMap)) {
            answer++;
        }
        // 슬라이딩 윈도우
        for (int i = 0; i < discount.length - 10; i++) {
            // 빠지는 제품 제거
            String outItem = discount[i];
            currentMap.put(outItem, currentMap.get(outItem) - 1);
            if (currentMap.get(outItem) == 0) {
                currentMap.remove(outItem);
            }
            // 들어갈 제품 넣기
            String inItem = discount[i + 10];
            currentMap.put(inItem, currentMap.getOrDefault(inItem, 0) + 1);
            // 맵이 같은 지 확인
            if (wantMap.equals(currentMap)) {
                answer++;
            }
        }
        return answer;
    }

}