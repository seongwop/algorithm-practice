class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // startday를 7로 나눴을 때 6,0일때 무시
        // 그 외는 +10 보다 작은 지 계산
        // +10 계산 시 60분 기준 검사
        for (int i = 0; i < schedules.length; i++) {
            boolean correct = true;
            for (int j = startday; j < startday + 7; j++) {
                if (j % 7 == 6 || j % 7 == 0) continue;
                int k = j - startday;
                if (timelogs[i][k] > plus10(schedules[i])) {
                    correct = false;
                    break;
                }
            }
            if (correct) answer++;
        }
        return answer;
    }
    
    int plus10(int time) {
        int minute = (time + 10) % 100;
        if (minute >= 60) {
            return (time / 100 + 1) * 100 + (minute - 60); 
        }
        return time + 10;
    }
}