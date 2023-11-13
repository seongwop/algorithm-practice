import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int max;
    static int[][] ex = {{0, 0, 1}, {0, 0, -1}, {1, 1, 2}, {1, 1, 2}};
    static int[][] ey = {{1, 2, 1}, {1, 2, 1}, {0, 1, 0}, {0, -1, 0}};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j] = true;
                dfs(new int[]{i, j}, 1, map[i][j]);
                check[i][j] = false;
                func(new int[]{i, j}, map[i][j]);
            }
        }

        System.out.println(max);
    }

    static void dfs(int[] loc, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = loc[0] + dx[i];
            int y = loc[1] + dy[i];
            if (x >= 0 && x < N && y >= 0 && y < M && !check[x][y]) {
                check[x][y] = true;
                dfs(new int[]{x, y}, cnt + 1, sum + map[x][y]);
                check[x][y] = false;
            }
        }
    }

    static void func(int[] loc, int sum) {
        for (int i = 0; i < 4; i++) {
            int total = sum;
            for (int j = 0; j < 3; j++) {
                int x = loc[0] + ex[i][j];
                int y = loc[1] + ey[i][j];
                if (x < 0 || x > N - 1 || y < 0 || y > M - 1) {
                    break;
                }
                total += map[x][y];
            }
            max = Math.max(max, total);
        }
    }
}