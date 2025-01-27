import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main4485 {
    static int[][] visited;
    static int[][] cave;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true) {
            cnt++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) return;
            StringTokenizer st;
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = -1;
                }
            }
            cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            System.out.println("Problem " + cnt + ": " + visited[N -1][N - 1]);
        }
    }

    static void dijkstra() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> cave[o1[0]][o1[1]] - cave[o2[0]][o2[1]]);
        pq.offer(new int[]{0, 0});
        visited[0][0] = cave[0][0];
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cur = visited[x][y];
            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                    if (visited[tx][ty] == -1 || visited[tx][ty] > cur + cave[tx][ty]) {
                        visited[tx][ty] = cur + cave[tx][ty];
                        pq.offer(new int[]{tx, ty});
                    }
                }
            }
        }
    }
}
