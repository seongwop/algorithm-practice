import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 0: 위, 1: 우, 2: 아래 3: 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        Marvel start = new Marvel();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    start.redX = i;
                    start.redY = j;
                }
                if (c == 'B') {
                    start.blueX = i;
                    start.blueY = j;
                }
                board[i][j] = c;
            }
        }
        start.count = 0;
        
        System.out.println(bfs(start));
    }

    static int bfs(Marvel start) {
        Queue<Marvel> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Marvel marvel = queue.poll();

            if (marvel.count == 10) continue;

            for (int i = 0; i < 4; i++) {
                int redX = marvel.redX;
                int redY = marvel.redY;
                int blueX = marvel.blueX;
                int blueY = marvel.blueY;
                boolean isRedHole = false;
                boolean isBlueHole = false;

                while (true) {
                    int tempRedX = redX + dx[i];
                    int tempRedY = redY + dy[i];
                    if (board[tempRedX][tempRedY] == '#')
                        break;
                    if (board[tempRedX][tempRedY] == 'O') {
                        isRedHole = true;
                        break;
                    }
                    redX = tempRedX;
                    redY = tempRedY;
                }
                while (true) {
                    int tempBlueX = blueX + dx[i];
                    int tempBlueY = blueY + dy[i];
                    if (board[tempBlueX][tempBlueY] == '#')
                        break;
                    if (board[tempBlueX][tempBlueY] == 'O') {
                        isBlueHole = true;
                        break;
                    }
                    blueX = tempBlueX;
                    blueY = tempBlueY;
                }

                if (isBlueHole)
                    continue;
                else if (isRedHole)
                    return marvel.count + 1;

                if (redX == blueX && redY == blueY) {
                    if (i == 0) {
                        if (marvel.redX > marvel.blueX) redX++;
                        else blueX++;
                    } else if (i == 1) {
                        if (marvel.redY > marvel.blueY) blueY--;
                        else redY--;
                    } else if (i == 2) {
                        if (marvel.redX > marvel.blueX) blueX--;
                        else redX--;
                    } else if (i == 3) {
                        if (marvel.redY > marvel.blueY) redY++;
                        else blueY++;
                    }
                }
                if (marvel.redX == redX && marvel.redY == redY && marvel.blueX == blueX && marvel.blueY == blueY) continue;

                queue.offer(new Marvel(redX, redY, blueX, blueY, marvel.count + 1));
            }
        }
        return -1;
    }
}

class Marvel {
    int redX;
    int redY;
    int blueX;
    int blueY;
    int count;

    public Marvel() {};

    public Marvel(int redX, int redY, int blueX, int blueY, int count) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.count = count;
    }
}
