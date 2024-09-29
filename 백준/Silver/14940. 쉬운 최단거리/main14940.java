import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class main14940 {

    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];
        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) start = new int[]{i, j};
                graph[i][j] = num;
            }
        }
        bfs(visited, start, answer);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0 && visited[i][j] == false) {
                    sb.append("-1 ");
                    continue;
                }
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(boolean[][] visited, int[] start, int[][] answer) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int val = answer[current[0]][current[1]];
            for (int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m 
                && visited[x][y] == false && graph[x][y] != 0) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                    answer[x][y] =  val + 1;
                }
            }
        }
    }
}
