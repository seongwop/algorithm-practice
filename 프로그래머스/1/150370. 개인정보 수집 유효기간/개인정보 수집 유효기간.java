import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        int daysOfToday = convertToDays(today);
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String day = st.nextToken();
            String term = st.nextToken();
            if (daysOfToday >= convertToDays(day) + termsMap.get(term) * 28) {
                result.add(i + 1);
            }
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
    
    // 일 수로 환산 함수 
    int convertToDays(String string) {
        StringTokenizer st = new StringTokenizer(string, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        return year * 12 * 28 + month * 28 + day;
    }
}