import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        // 재생 시간 동안 이어지는 악보를 생성하고 contains로 확인
        int maxPeriod = -1;
        for (String info : musicinfos) {
            String[] infoArr = info.split(",");
            String[] startAt = infoArr[0].split(":");
            String[] endAt = infoArr[1].split(":");
            String title = infoArr[2];
            String music = infoArr[3];
            music = convert(music);
            int period = (Integer.parseInt(endAt[0]) * 60 + Integer.parseInt(endAt[1])) - (Integer.parseInt(startAt[0]) * 60 + Integer.parseInt(startAt[1]));
            // 재생 시간동안 완성된 악보 구하기
            StringBuilder fullMusic = new StringBuilder();
            
            for (int i = 0; i < period; i++) {
                int curIdx = i % music.length();
                fullMusic.append(music.charAt(curIdx));
            }
            
            m = convert(m);
            
            if (fullMusic.toString().contains(m) && maxPeriod < period) {
                maxPeriod = period;
                answer = title;
            }
        }
        return answer;
    }
    
    String convert(String music) {
        return music
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
    }
}