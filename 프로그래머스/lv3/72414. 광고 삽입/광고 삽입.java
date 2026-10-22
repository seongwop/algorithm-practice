class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        // 누적합 차분배열
        int[] diff = new int[convertToSec(play_time) + 1];
        for (String log : logs) {
            String[] term = log.split("-");
            int startTime = convertToSec(term[0]);
            int endTime = convertToSec(term[1]);
            diff[startTime]++;
            diff[endTime]--;
        }
        
        // 누적합 계산
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        
        // 투 포인터로 해당 간격의 최대 합 구하기
        long maxTerm = 0;
        long currentTerm = 0;
        int fastestStartTime = 0;
        int left = 0;
        int startRight = convertToSec(adv_time);
        // 첫 구간 합
        for (int i = left; i < startRight; i++) {
            currentTerm += diff[i];
        }
        maxTerm = currentTerm;
        for (int i = startRight; i < diff.length - 1; i++) {
            currentTerm -= diff[left];
            left++;
            currentTerm += diff[i];
            if (maxTerm < currentTerm) {
                fastestStartTime = left;
                maxTerm = currentTerm;
            }
        }
        
        return convertToStr(fastestStartTime);
    }
    
    int convertToSec(String time) {
        String[] timeArr = time.split(":");
        return 
            Integer.parseInt(timeArr[0]) * 60 * 60 + 
            Integer.parseInt(timeArr[1]) * 60 + 
            Integer.parseInt(timeArr[2]);
    }
    
    String convertToStr(int time) {
        int hour = time / 3600;
        int minute = (time % 3600) / 60;
        int second = (time % 3600) % 60;
        String hStr = String.valueOf(hour).length() == 2 ? String.valueOf(hour) : "0" + String.valueOf(hour);
        String mStr = String.valueOf(minute).length() == 2 ? String.valueOf(minute) : "0" + String.valueOf(minute);
        String sStr = String.valueOf(second).length() == 2 ? String.valueOf(second) : "0" + String.valueOf(second);
        return hStr + ":" + mStr + ":" + sStr;
    }
}