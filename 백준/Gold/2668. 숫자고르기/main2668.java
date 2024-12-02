import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main2668 {
    static int N;
    static int[] arr;
    static ArrayList<Integer> al = new ArrayList<>(); 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            bfs(i, arr[i], visited);
            visited[i] = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(al.size() + "\n");
        for (int i = 0; i < al.size(); i++) {
            sb.append(al.get(i) + "\n");
        }
        System.out.println(sb);

    }

    static void bfs(int start, int next, boolean[] visited) {
        if (start == arr[next]) {
            al.add(start);
            return;
        }
        if (!visited[next]) {
            visited[next] = true;
            bfs(start, arr[next], visited);
            visited[next] = false;
        } else return;
    }
}
