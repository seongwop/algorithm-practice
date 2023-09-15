import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int[][] board = new int[N + 1][N + 1];
        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        int time = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] head = {1, 1};
        int dir = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(101);

        int L = Integer.parseInt(bf.readLine());
        int prevTime = 0;
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int curTime = Integer.parseInt(st.nextToken());
            for (int j = 0; j < curTime - prevTime; j++) {
                time++;
                head[0] += dy[dir];
                head[1] += dx[dir];
                if (queue.contains(head[0] * 100 + head[1]) || head[0] < 1 || head[1] < 1 || head[0] > N || head[1] > N) {
                    System.out.println(time);
                    return;
                }
                if (board[head[0]][head[1]] == -1) {
                    queue.add(head[0] * 100 + head[1]);
                    board[head[0]][head[1]] = 0;
                } else {
                    queue.add(head[0] * 100 + head[1]);
                    queue.poll();
                }
            }
            prevTime = curTime;
            dir = st.nextToken().equals("D") ? (4 + (dir + 1)) % 4 : (4 + (dir - 1)) % 4;
        }
        while (true) {
            time++;
            head[0] += dy[dir];
            head[1] += dx[dir];
            if (queue.contains(head[0] * 100 + head[1]) || head[0] < 1 || head[1] < 1 || head[0] > N || head[1] > N) {
                System.out.println(time);
                break;
            }
        }
    }
}