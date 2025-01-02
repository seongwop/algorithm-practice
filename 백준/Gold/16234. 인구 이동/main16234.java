import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main16234 {
    static int[][] map;
    static ArrayList<Node> arr = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean check = true;
    static int N, L, R, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (check) {
            check = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int total = bfs(new int[]{i, j});
                        for (Node n : arr) {
                            map[n.x][n.y] = total / arr.size();
                        }
                    }
                    arr.clear();
                }
            }
            if (check) cnt++;
        }
        System.out.println(cnt);
    }

    static int bfs(int[] current) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(current);
        int total = map[current[0]][current[1]];
        arr.add(new Node(current[0], current[1]));
        visited[current[0]][current[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();   

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                    int dif = Math.abs(map[cur[0]][cur[1]] - map[x][y]);
                    if (dif >= L && dif <= R) {
                        queue.offer(new int[]{x, y});
                        total += map[x][y];
                        visited[x][y] = true;
                        arr.add(new Node(x, y));
                        check = true;
                    }
                }
            }
        }
        return total;
    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
