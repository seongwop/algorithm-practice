import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 2차원 배열로 표현
        // [i][j] 와 [j][i] 를 비교해서 더 큰 i가 하나 받기
        // 문자열 인덱스 매핑 HashMap
        Map<String, Integer> friendMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }
        int[][] giftArray = new int[friends.length][friends.length];
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String sGift = st.nextToken();
            String rGift = st.nextToken();
            giftArray[friendMap.get(sGift)][friendMap.get(rGift)]++;
        }
        int[] giftPoint = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            int point = 0;
            for (int j = 0; j < friends.length; j++) {
                point += giftArray[i][j];
            }
            giftPoint[i] = point;
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                giftPoint[i] -= giftArray[j][i];   
            }
        }
        
        int[] giftNum = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (giftArray[i][j] > giftArray[j][i]) {
                    giftNum[i]++;
                } else if (giftArray[i][j] == giftArray[j][i]) {
                    if (giftPoint[i] > giftPoint[j]) {
                        giftNum[i]++;
                    }
                }
            }
        }
        for (int num : giftNum) {
            answer = Math.max(answer, num);
        }
        return answer;
    }
}