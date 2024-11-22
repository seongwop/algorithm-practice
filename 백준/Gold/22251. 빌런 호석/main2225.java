import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main2225 {
    static int answer = 0;
    static int N, K, P, X;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        String floor = st.nextToken();
        X = Integer.parseInt(floor);
        arr = new int[][]{
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};

        dfs(0, 1, 0, 0);
        System.out.println(answer - 1);
    }

    static void dfs(int num, int ten, int now, int cnt) {
        if (now > N || cnt > P) return;
        if (num == K) {
            if (now != 0) answer++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            dfs(num + 1, 10 * ten, i * ten + now, cnt + arr[X / ten % 10][i]);
        }
     }
}