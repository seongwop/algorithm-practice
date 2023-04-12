import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] current = new int[n];
        Arrays.fill(current, 1);
        for (int idx : lost) current[idx - 1] -= 1;
        for (int idx : reserve) current[idx - 1] += 1;
        
        for (int i = 1; i < n; i++) {
            if (current[i] == 2 && current[i - 1] == 0) {
                current[i]--;
                current[i - 1]++;
            }
            if (current[i] == 0 && current[i - 1] == 2) {
                current[i]++;
                current[i - 1]--;
            }
        }
        for (int i = 0; i < n; i++) 
            if (current[i] >= 1) answer++;

        return answer;
    }
}