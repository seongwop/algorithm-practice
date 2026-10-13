import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int minimumTime = fees[0];
        int minimumFee = fees[1];
        int addedTime = fees[2];
        int addedFee = fees[3];
        Map<String, Integer> timeMap = new HashMap<>();
        TreeMap<String, Integer> timeTree = new TreeMap<>();
        // 각 번호당 시간을 구하고 번호 기준 정렬
        for (String record : records) {
            String[] recordArr = record.split(" ");
            String[] timeArr = recordArr[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String num = recordArr[1];
            // 이미 맵에 키가 존재할 경우 해당 키는 IN, 들어갈 값은 OUT
            if (timeMap.containsKey(num)) {
                int period = time - timeMap.get(num);
                timeTree.put(num, timeTree.getOrDefault(num, 0) + period);
                timeMap.remove(num);
            // 맵에 키가 없을 경우 IN 추가
            } else {
                timeMap.put(num, time);
            }
        }
        for (String key : timeMap.keySet()) {
            int period = (23 * 60 + 59) - timeMap.get(key);
            timeTree.put(key, timeTree.getOrDefault(key, 0) + period);
        }
        for (String key : timeTree.keySet()) {
            int totalTime = timeTree.get(key);
            int fee = minimumFee;
            if (totalTime > minimumTime) {
                fee += ((totalTime - minimumTime + addedTime - 1) / addedTime) * addedFee;
            }
            timeTree.put(key, fee);
        }
        
        return timeTree.values().stream().mapToInt(Integer::intValue).toArray();
    } 
}