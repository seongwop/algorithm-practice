import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main1260 {

    static boolean[][] graph;
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }

        boolean[] visited = new boolean[N + 1];
        dfs(start, visited);
        System.out.println(sb);
        
        sb.setLength(0);
        visited = new boolean[N + 1];
        bfs(start, visited);
        System.out.println(sb);
    }

    static void dfs(int next, boolean[] visited) {
        sb.append(next + " ");
        visited[next] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[next][i] == true && visited[i] == false) dfs(i, visited);
        }
        return;
    }

    static void bfs(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        sb.append(start + " ");
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[current][i] == true && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }
}
