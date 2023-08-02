import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 처음과 마지막 끝 부분을 제외하고는 최댓값으로 갱신
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j  = 0; j < triangle[i + 1].length; j++) {
                if (j == 0) {
                    triangle[i + 1][j] += triangle[i][j];
                } else if (j == triangle[i + 1].length - 1) {
                    triangle[i + 1][j] += triangle[i][j - 1];
                } else {
                    triangle[i + 1][j] += Math.max(triangle[i][j - 1], triangle[i][j]);
                }
            }
        }
        for (int num : triangle[triangle.length - 1]) {
            if (num > answer) answer = num;
        }
    
        return answer;
    }
}