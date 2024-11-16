import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] chars = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }

            int[] arr = new int[26];
            for (int j = 0; j < chars.length; j++) {
                arr[chars[j] - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int j = 0; j < chars.length; j++) {
                if (arr[chars[j] - 'a'] < K) continue;
                int cnt = 1;
                for (int l = j + 1; l < chars.length; l++) {
                    if (chars[j] == chars[l]) cnt++;
                    if (cnt == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) sb.append("-1");
            else sb.append(min + " " + max);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
