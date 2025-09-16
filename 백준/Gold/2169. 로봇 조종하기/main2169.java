import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main2169 {
    
    static int[][][] dp;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[4][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[3][0][0] = dp[0][0][0];
        for (int i = 1; i < M; i++) {
            dp[3][0][i] = dp[3][0][i - 1] + dp[0][0][i];
        }
        for (int i = 1; i < N; i++) {
            // 위, 왼에서 올 경우
            for (int j = 0; j < M; j++) {
                if (j == 0) dp[1][i][j] = dp[3][i - 1][j] + dp[0][i][j];
                else dp[1][i][j] = Math.max(dp[3][i - 1][j], dp[1][i][j - 1]) + dp[0][i][j];
            }
            // 위, 오에서 올 경우
            for (int k = M - 1; k >= 0; k--) {
                if (k == M - 1) dp[2][i][k] = dp[3][i - 1][k] + dp[0][i][k];
                else dp[2][i][k] = Math.max(dp[3][i - 1][k], dp[2][i][k + 1]) + dp[0][i][k];
            }
            for (int j = 0; j < M; j++) {
                dp[3][i][j] = Math.max(dp[1][i][j], dp[2][i][j]);
            }
        }
        System.out.println(dp[3][N - 1][M - 1]);
    }
}
