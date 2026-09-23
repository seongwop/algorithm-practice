import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] dropList = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dropList[i], drops.length + 1);
        }
        for (int i = 0; i < drops.length; i++) {
            dropList[drops[i][0]][drops[i][1]] = i + 1;
        }
        int[][] rowMin = new int[m][n - w + 1];
        // 행 기준 가로 슬라이딩 윈도우 최솟값
        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                // 슬라이딩 범위에 벗어나면 poll
                if (!dq.isEmpty() && dq.peekFirst() <= j - w) {
                    dq.pollFirst();
                }
                // 이미 큐에 들어있는 값이 더 큰 값일 경우 최소값을 위해 poll
                while (!dq.isEmpty() && dropList[i][dq.peekLast()] >= dropList[i][j]) {
                    dq.pollLast();
                }
                dq.offerLast(j);
                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = dropList[i][dq.peekFirst()];
                }
            }
        }
        
        int[][] colMin = new int[m - h + 1][n - w + 1];
        // 열 기준 세로 슬라이딩 윈도우 최솟값
        for (int i = 0; i < n - w + 1; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                if (!dq.isEmpty() && dq.peekFirst() <= j - h) {
                    dq.pollFirst();
                }
                while (!dq.isEmpty() && rowMin[dq.peekLast()][i] >= rowMin[j][i]) {
                    dq.pollLast();
                }
                dq.offerLast(j);
                if (j >= h - 1) {
                    colMin[j - h + 1][i] = rowMin[dq.peekFirst()][i];
                }
            }
        }
        int max = -1, x = -1, y = -1;
        for (int i = 0; i <= m - h; i++) {
            for (int j = 0; j <= n - w; j++) {
                if (max < colMin[i][j]) {
                    x = i;
                    y = j;
                    max = colMin[i][j];
                }
            }
        }
        return new int[]{x, y};
    }
}