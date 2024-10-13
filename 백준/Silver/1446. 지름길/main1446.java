import java.util.*;
import java.io.*;

public class main1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        int[] dp = new int[D + 1];

        for (int i = 0; i <= D; i++) dp[i] = i;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for (int j = 0; j < N; j++) {
                int start = arr[j][0];
                int dest = arr[j][1];
                int dist = arr[j][2];
                if (start < 0 || dest > D || dest - start < dist) continue;
                if (start == i) {
                    dp[dest] = Math.min(dp[start] + dist, dp[dest]);
                }
            }
        }
        System.out.println(dp[D]);
    
    }
}