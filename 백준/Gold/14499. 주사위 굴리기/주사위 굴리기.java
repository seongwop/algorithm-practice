import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dice = {0, 0, 0, 0, 0, 0, 0};
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] current;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        current = new int[]{x, y};
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int d = Integer.parseInt(st.nextToken());
            int result = move(current, d);
            if (result != -1) {
                System.out.println(result);
            }
        }
    }

    static int move(int[] current, int d) {
          if (current[0] + dx[d - 1] < 0 || current[0] + dx[d - 1] > N - 1 || current[1] + dy[d - 1] < 0 || current[1] + dy[d - 1] > M - 1) {
              return -1;
          }
          current[0] += dx[d - 1];
          current[1] += dy[d - 1];
          roll(d);
            if (map[current[0]][current[1]] == 0) {
                map[current[0]][current[1]] = dice[6];
            } else {
                dice[6] = map[current[0]][current[1]];
                map[current[0]][current[1]] = 0;
            }
            return dice[1];
    }

    static void roll(int d) {
          int temp = dice[1];
          switch (d) {
              case 1 :
                  dice[1] = dice[4];
                  dice[4] = dice[6];
                  dice[6] = dice[3];
                  dice[3] = temp;
                  break;
              case 2 :
                  dice[1] = dice[3];
                  dice[3] = dice[6];
                  dice[6] = dice[4];
                  dice[4] = temp;
                  break;
              case 3 :
                  dice[1] = dice[5];
                  dice[5] = dice[6];
                  dice[6] = dice[2];
                  dice[2] = temp;
                  break;
              case 4 :
                  dice[1] = dice[2];
                  dice[2] = dice[6];
                  dice[6] = dice[5];
                  dice[5] = temp;
                  break;
          }
    }
}