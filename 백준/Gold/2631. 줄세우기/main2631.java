import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main2631 {
    public static void main(String[] args) throws IOException {
        // LIS (Longest Increasing Subsequence)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N];
        int length = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            length = Math.max(length, dp[i]);
        }
        System.out.println(N - length);
    }
}
