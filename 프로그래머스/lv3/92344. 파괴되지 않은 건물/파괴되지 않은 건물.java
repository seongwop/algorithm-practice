class Solution {
    public int solution(int[][] board, int[][] skill) {
        int destroyed = 0;
        int h = board.length;
        int w = board[0].length;
        
        // 누적합을 통한 차분 배열
        // 3 3 0       3 0 -3
        // 3 3 0  -->  0 0 0   의 누적합
        // 0 0 0       -3 0 3
        
        int[][] diffArr = new int[h + 1][w + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            if (type == 1) {
                diffArr[r1][c1] += -1 * degree;
                diffArr[r1][c2 + 1] += degree;
                diffArr[r2 + 1][c1] += degree;
                diffArr[r2 + 1][c2 + 1] += -1 * degree;
            } else {
                diffArr[r1][c1] += degree;
                diffArr[r1][c2 + 1] += -1 * degree;
                diffArr[r2 + 1][c1] += -1 * degree;
                diffArr[r2 + 1][c2 + 1] += degree;
            }
        }
        // 누적합
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                diffArr[i][j + 1] += diffArr[i][j];
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                diffArr[j + 1][i] += diffArr[j][i];
            }
        }
        // 맨 끝 열과 행을 제외하고 0 또는 음수값
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] + diffArr[i][j] <= 0) destroyed++;
            }
        }

        return h * w - destroyed;
    }
}