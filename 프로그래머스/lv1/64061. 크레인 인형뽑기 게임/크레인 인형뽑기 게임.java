import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 바구니를 ArrayList로 생성
        List<Integer> list = new ArrayList<>();
        
        // moves를 돌며 하나씩 빼오면서 하나빼면 해당 원소를 0으로 바꾸고 ArrayList에 추가
        for (int j = 1; j <= moves.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][moves[j - 1] - 1] != 0) {
                    list.add(board[i][moves[j - 1] - 1]);
                    board[i][moves[j - 1] - 1] = 0;
                    break;
                }
            }
            // ArrayList의 마지막 두 원소가 같다면 둘 다 삭제 후 답에 2 추가
            if (list.size() >= 2 && list.get(list.size() - 1) == list.get(list.size() - 2)) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                answer += 2;
            }
        }
        return answer;
    }
}