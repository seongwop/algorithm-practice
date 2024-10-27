import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] loc = new int[100001];
        int cur = 0;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(N);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == K) {
                System.out.println(loc[cur]);
                break;
            }
            if (cur + 1 <= 100000 && loc[cur + 1] == 0) {
                loc[cur + 1] = loc[cur] + 1;
                queue.offer(cur + 1);
            }
            if (cur - 1 >= 0 && loc[cur - 1] == 0) {
                loc[cur - 1] = loc[cur] + 1;
                queue.offer(cur - 1);
            }   
            if (cur * 2 <= 100000 && loc[cur * 2] == 0) {
                loc[cur * 2] = loc[cur] + 1;
                queue.offer(cur * 2);
            }
        }  
    }
}