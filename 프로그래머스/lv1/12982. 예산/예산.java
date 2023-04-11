import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 금액이 적은 순으로 정렬
        Arrays.sort(d);
        int sum = 0;
        // 적은 순으로 더하다가 마지막으로 더한 금액이 예산을 넘어갈 경우 하나 뺌
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            answer++;
            if (sum > budget) answer--;
        }
        return answer;
    }
}