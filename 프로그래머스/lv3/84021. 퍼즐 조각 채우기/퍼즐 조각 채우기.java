import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<List<Point>> blanks = getPieces(game_board, 1);
        List<List<Point>> puzzles = getPieces(table, 0);
        boolean[] usedPuzzles = new boolean[puzzles.size()];
        for (int i = 0; i < blanks.size(); i++) {
            List<Point> blank = blanks.get(i);
            for (int j = 0; j < puzzles.size(); j++) {
                if (usedPuzzles[j]) continue;
                List<Point> puzzle = puzzles.get(j);
                if (blank.size() != puzzle.size()) continue;
                
                boolean matched = false;
                for (int k = 0; k < 4; k++) {
                    puzzle = rotate(puzzle);
                    if (isFit(blank, puzzle)) {
                        usedPuzzles[j] = true;
                        answer += blank.size();
                        matched = true;
                        break;
                    }
                }
                if (matched) break;
            }
        }
        
        return answer;
    }
    // 조각들을 리스트에 담는 메서드
    List<List<Point>> getPieces(int[][] board, int numToPass) {
        List<List<Point>> blanks = new ArrayList<>();
        int[] moveR = {1, -1, 0, 0};
        int[] moveC = {0, 0, 1, -1};
        // 각 지점에서 bfs로 탐색
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == numToPass) continue;
                Queue<Point> queue = new ArrayDeque<>();
                List<Point> list = new ArrayList<>();
                queue.offer(new Point(i, j));
                board[i][j] = numToPass;
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    list.add(p);
                    for (int k = 0; k < 4; k++) {
                        int r = p.r + moveR[k];
                        int c = p.c + moveC[k];
                        if (r < 0 || r >= board.length || c < 0 || c >= board.length || board[r][c] == numToPass) continue;
                        queue.offer(new Point(r, c));
                        board[r][c] = numToPass;
                    }
                }
                Collections.sort(list, (a, b) -> {
                    if (a.r == b.r) return Integer.compare(a.c, b.c);
                    return Integer.compare(a.r, b.r);
                });
                blanks.add(normalize(list));
            }
        }
        return blanks;
    }
    
    // 90도 회전
    List<Point> rotate(List<Point> points) {
        List<Point> rotated = new ArrayList<>();
        for (Point point : points) {
            rotated.add(new Point(point.c, -point.r));
        }
        return normalize(rotated);
    }
    
    // (0, 0) 기준으로 정규화
    List<Point> normalize(List<Point> points) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        for (Point point : points) {
            minR = Math.min(minR, point.r);
            minC = Math.min(minC, point.c);
        }
        List<Point> normalized = new ArrayList<>();
        for (Point point : points) {
            normalized.add(new Point(point.r - minR, point.c - minC));
        }
        
        Collections.sort(normalized, (a, b) -> {
            if (a.r == b.r) return Integer.compare(a.c, b.c);
            return Integer.compare(a.r, b.r);
        });
        
        return normalized;
    }
    
    boolean isFit(List<Point> blank, List<Point> puzzle) {
        if (blank.size() != puzzle.size()) return false;
        for (int i = 0; i < blank.size(); i++) {
            if (blank.get(i).r != puzzle.get(i).r || blank.get(i).c != puzzle.get(i).c) {
                return false;
            }
        }
        return true;
    }
    
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}