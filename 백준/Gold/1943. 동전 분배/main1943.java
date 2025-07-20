import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] dp;
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[N];
            int total = 0;
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                coins[j] = new Coin(price, count);
                total += price * count;
            }

            if (total % 2 == 1) {
                System.out.println(0);
            } else {
                total /= 2;
                dp = new boolean[N + 1][total + 1];
                dp[0][0] = true;
                for (int j = 1; j <= N; j++) {
                    Coin coin = coins[j - 1];
                    for (int k = 0; k <= total; k++) {
                        if (dp[j - 1][k]) {
                            for (int l = 0; l <= coin.count; l++) {
                                if (k + coin.price * l <= total) dp[j][k + coin.price * l] = true;   
                            }
                        }
                    }
                }
                if (dp[N][total]) System.out.println(1);
                else System.out.println(0);
            }
        }   
    }

    static class Coin {
        int price, count;
        public Coin(int price, int count) {
            this.price = price;
            this.count = count;
        }
    } 
}