import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main2206 {
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0 , 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (!cur.broken && !visited[x][y][0]) {
                    if (map[x][y] == '1') {
                        queue.add(new Node(x, y, cur.cnt + 1, true));
                        visited[x][y][1] = true;
                    } else {
                        queue.add(new Node(x, y, cur.cnt + 1, false));
                        visited[x][y][0] = true; 
                    }
                        
                } else if (cur.broken && !visited[x][y][1]) {
                    if (map[x][y] == '0') {
                        queue.add(new Node(x, y, cur.cnt + 1, true));
                        visited[x][y][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int x;
        int y;
        int cnt;
        boolean broken;
        
        public Node(int x, int y, int cnt, boolean broken) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.broken = broken;
        }
    }
}
