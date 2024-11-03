import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] loc = new int[100001];
        loc[N] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();        
            if (cur + 1 <= 100000 && (loc[cur + 1] > loc[cur] + 1 || loc[cur + 1] == 0)) {
                loc[cur + 1] = loc[cur] + 1;
                queue.offer(cur + 1);
            }
            if (cur - 1 >= 0 && (loc[cur - 1] > loc[cur] + 1 || loc[cur - 1] == 0)) {
                loc[cur - 1] = loc[cur] + 1;
                queue.offer(cur - 1);
            }
            if (2 * cur <= 100000 && (loc[2 * cur] > loc[cur] || loc[2 * cur] == 0)) {
                loc[2 * cur] = loc[cur];
                queue.offer(2 * cur);
            }
        }
        System.out.println(loc[K] - 1);
    }
}
