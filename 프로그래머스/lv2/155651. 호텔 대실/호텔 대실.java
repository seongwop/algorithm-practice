class Solution {
    public int solution(String[][] book_time) {
        int maxRoom = 0;
        int n = book_time.length;
        int[][] book_time_minute = new int[n][2];
        int[] timeline = new int[24 * 60 + 60];

        // 총 시간을 10분 단위로 쪼개서 배열에 저장
        for (int i = 0; i < n; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":"); 
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            timeline[startTime]++;
            timeline[endTime + 10]--;
        }
        
        int currentRoom = 0;
        for (int i = 0; i < timeline.length; i++) {
            currentRoom += timeline[i];
            maxRoom = Math.max(maxRoom, currentRoom);
        }
        
        return maxRoom;
    }
}