import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main16928 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[101][2];
        for (int i = 1; i < 101; i++) {
            board[i][0] = i;
        }
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][1] = Integer.parseInt(st.nextToken());
        }

        int[] visited = new int[101];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                if (cur + i <= 100 && board[cur + i][1] == 0 && visited[cur + i] == 0) {
                    queue.offer(cur + i);
                    visited[cur + i] = visited[cur] + 1;
                } else if (cur + i <= 100 && board[cur + i][1] != 0 & visited[board[cur + i][1]] == 0) {
                    queue.offer(board[cur + i][1]);
                    visited[board[cur + i][1]] = visited[cur] + 1;
                }
            }
            if (visited[100] != 0) {
                break;
            }
        }
        System.out.println(visited[100]);
    }
}
