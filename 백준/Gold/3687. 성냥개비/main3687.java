import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class main3687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;
        String[] add = {"1", "7", "4", "2", "0", "8"};
        for (int i = 9; i < 101; i++) {
            for (int j = 2; j <= 7; j++) {
                dp[i] = Math.min(dp[i], Long.parseLong(dp[i - j] + add[j - 2]));
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num] + " ");
            if (num % 2 == 0) sb.append("1");
            else sb.append("7");
            for (int j = 1; j < num / 2; j++) {
                sb.append("1");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}