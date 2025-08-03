import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main9527 {
    static long A, B;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A  = Long.parseLong(st.nextToken());
        B  = Long.parseLong(st.nextToken());
        dp = new long[55];
        dp[0] = 1;
        // dp[n] = 2^n + 2*dp[n-1]
        for (int i = 1; i < 55; i++) {
            dp[i] = (1L << i) + 2 * dp[i - 1]; 
        }
        System.out.println(countOne(B) - countOne(A - 1));

    }

    static long countOne(long N) {
        // 젤 마지막 자릿수만 미리 계산
        long cnt = N & 1;
        // 이진수로 변환했을 때 몇자리수인지 계산
        int n = (int)(Math.log(N) / Math.log(2));
        for (int i = n; i > 0; i--) {
            // 해당 자리의 수가 0일 경우 패스
            if ((N & (1L << i)) == 0) continue;
            // 13(1101)의 경우 맨 앞 1이 되기까지 000~111 (dp[i-1]개) + 000~101(13 - 2^3개) + 000 (1개)
            cnt += dp[i - 1] + (N - (1L << i) + 1L);
            // 맨 앞 1 빼기
            N -= 1L << i;
        }
        return cnt;
    }
}
