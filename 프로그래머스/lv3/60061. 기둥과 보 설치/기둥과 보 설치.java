import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> result = new ArrayList<>();
        boolean[][][] building = new boolean[n + 1][n + 1][2];
        
        int countFrame = 0;
        for (int[] frame : build_frame) {
            int x = frame[0]; // 가로
            int y = frame[1]; // 세로
            int a = frame[2]; // 0: 기둥 1: 보
            if (frame[3] == 0) { // 삭제
                if (isValid(n, frame, building)) {
                    building[x][y][a] = false;
                    countFrame--;
                }
            } else {
                if (canInstall(n, frame, building)) {
                    building[x][y][a] = true;
                    countFrame++;
                }
            }
        }

        
        
        int[][] answer = new int[countFrame][3];
        int idx = 0;
        for (int i = 0; i < n + 1; i ++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    if (building[i][j][k] == true) {
                        answer[idx++] = new int[]{i, j, k};
                    }
                }
            }
        }
        
        return answer;
    }
    
    // 설치 함수
    boolean canInstall(int n, int[] frame, boolean[][][] building) {
        int x = frame[0]; // 가로
        int y = frame[1]; // 세로
        int a = frame[2]; // 0: 기둥 1: 보
        // 기둥일 때
        if (a == 0) {
            // 바닥 위
            if (y == 0) {
                return true;
            // 보의 한 쪽 끝
            } else if (x - 1 >= 0 && building[x - 1][y][1] == true || building[x][y][1] == true) {
                return true;
            // 다른 기둥 위
            } else if (y - 1 >= 0 && building[x][y - 1][0] == true) {
                return true;
            }
        // 보일 때
        } else {
            // 한쪽 끝이 기둥 위 
            if ((y - 1 >= 0 && building[x][y - 1][0] == true) || (x + 1 <= n && y - 1 >= 0 && building[x + 1][y - 1][0] == true)) {
                return true;
            // 양쪽 끝이 다른 보와 연결
            } else if (x - 1 >= 0 && building[x - 1][y][1] == true && x + 1 <= n && building[x + 1][y][1] == true) {
                return true;
            }
        }
        return false;
    }
    
    // 삭제했을 때 유지가 가능한 지 여부
    boolean isValid(int n, int[] frame, boolean[][][] building) {
        int x = frame[0]; // 가로
        int y = frame[1]; // 세로
        int a = frame[2]; // 0: 기둥 1: 보
        if (building[x][y][a] == false) return true;
        building[x][y][a] = false;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    if (building[i][j][k] && !canInstall(n, new int[]{i, j, k}, building)) {
                        building[x][y][a] = true;
                        return false;
                    }
                }
            }
        }
        building[x][y][a] = true;
        return true;
    }
}