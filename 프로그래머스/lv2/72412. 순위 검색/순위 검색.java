import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        List<Integer> result = new ArrayList<>();
        
        // String, List의 해시맵으로 info의 모든 조합을 관리
        // 모든 경우에 - 를 포함해서 조합
        
        Map<String, List<Integer>> infoMap = new HashMap<>();
        
        for (String infoString : info) {
            String[] infoArr = infoString.split(" ");
            int currentScore = Integer.parseInt(infoArr[4]);
            getInfoComb(infoArr, "", 0, currentScore, infoMap);
        }
        
        for (List<Integer> scoreList : infoMap.values()) {
            Collections.sort(scoreList);
        }
        
        for (String queryString : query) {
            queryString = queryString.replace(" and ", " ");
            String[] queryArr = queryString.split(" ");
            // key 문자열
            String q = queryArr[0] + queryArr[1] + queryArr[2] + queryArr[3];
            // 해당 점수보다 큰 점수를 찾기
            int score = Integer.parseInt(queryArr[4]);
            
            if (!infoMap.containsKey(q)) {
                result.add(0);
            } else {
                List<Integer> scoreList = infoMap.get(q);
                
                int left = 0;
                int right = scoreList.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (scoreList.get(mid) < score) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result.add(scoreList.size() - left);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    void getInfoComb(String[] infoArr, String currentStr, int cnt, int score, Map<String, List<Integer>> infoMap) {
        if (cnt == 4) {
            if (infoMap.containsKey(currentStr)) {
                infoMap.get(currentStr).add(score);
                return;
            } else {
                infoMap.put(currentStr, new ArrayList<>(Arrays.asList(score)));
                return;
            }
        } 
        getInfoComb(infoArr, currentStr + infoArr[cnt], cnt + 1, score, infoMap);
        getInfoComb(infoArr, currentStr + "-", cnt + 1, score, infoMap);
    }
}