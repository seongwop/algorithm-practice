class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int n = book_time.length;
        int[][] book_time_minute = new int[n][2];
        int startTime = 24 * 60 + 60;
        int endTime = 0;
        // 총 시간을 10분 단위로 쪼개서 배열에 저장
        for (int i = 0; i < n; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":"); 
            book_time_minute[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            startTime = Math.min(startTime, book_time_minute[i][0]);
            book_time_minute[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 9;
            endTime = Math.max(endTime, book_time_minute[i][1]);
        }
        
        // 10분 간격으로 방 최대 개수 갱신
        for (int i = startTime; i <= endTime; i ++) {
            int count = 0;
            for (int[] term : book_time_minute) {
                if (i >= term[0] && i <= term[1]) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
        }
        
        
        return answer;
    }
}