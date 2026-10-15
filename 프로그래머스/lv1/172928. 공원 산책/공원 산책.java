import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int h = park.length;
        int w = park[0].length();
        // int 배열 시작점 1 장애물 -1 그 외 0
        int[] start = new int[2];
        for (int i = 0; i < park.length; i++) {
            String s = park[i];
            for (int j = 0; j < park[0].length(); j++) {
                if (s.charAt(j) == 'S') {
                    start = new int[]{i, j};
                } 
            }
        }
        for (String route : routes) {
            StringTokenizer st = new StringTokenizer(route);
            int[] dir = move(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int dh = dir[0];
            int dw = dir[1];
            boolean valid = true;
            for (int i = 1; i <= num; i++) {
                if (start[0] + dh * i >= h || start[0] + dh * i < 0 || start[1] + dw * i >= w || start[1] + dw * i < 0 || park[start[0] + dh * i].charAt(start[1] + dw * i) == 'X') {
                    valid = false;
                }
            }
            if (valid) {
                start = new int[]{start[0] + num * dh, start[1] + num * dw};
            }
        }
                
        return start;
    }
    
    int[] move(String route) {
        // E {0, 1} W {0, -1} S {1, 0} M {-1, 0}
        char dir = route.charAt(0);
        if (dir == 'E') {
            return new int[]{0, 1};
        } else if (dir == 'W') {
            return new int[]{0, -1};
        } else if (dir == 'S') {
            return new int[]{1, 0};
        } else if (dir == 'N') {
            return new int[]{-1, 0};
        }
        return new int[]{};
    }
}