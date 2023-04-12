import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 1로 초기화된 배열에서 도난 당한 학생은 1을 빼고, 여벌이 있는 학생은 1을 더함
        int[] current = new int[n];
        Arrays.fill(current, 1);
        for (int idx : lost) current[idx - 1] -= 1;
        for (int idx : reserve) current[idx - 1] += 1;
        
        // 붙어있는 인덱스를 조회하면서 서로 0, 2라면 1, 1로 만들어줌
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