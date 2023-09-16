import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int[][] array = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(N, array, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int N, int[][] array, int cur, int total) {
        if (cur >= N) {
            if (answer < total) {
                answer = total;
            }
            return;
        }
        for (int i = cur; i < N; i++) {
            if (i + array[i][0] <= N) {
                dfs(N, array, i + array[i][0], total + array[i][1]);
            } else {
                dfs(N, array, i + array[i][0], total);
            }

        }
    }
}