import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; 
        int start = 1;
        
        for (int i = 0; i < stations.length; i++) {
            if (stations[i] - w > start) {
                if ((stations[i] - w - start) % (w * 2 + 1) == 0) {
                    answer += (stations[i] - w - start) / (w * 2 + 1);
                } else {
                    answer += (stations[i] - w - start) / (w * 2 + 1) + 1;
                }
            } 
            start = stations[i] + w + 1;
        }
        if (start <= n) {
            if ((n - start + 1) % (w * 2 + 1) == 0) {
                answer += (n - start + 1) / (w * 2 + 1);
            } else {
                answer += (n - start + 1) / (w * 2 + 1) + 1;
            }
        }
        return answer;
    }
}