import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main7490 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, 1, 0, 1, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int num, int sum, int op, String express) {
        if (idx == N) {
            sum += num * op;
            if (sum == 0) {
                sb.append(express + "\n");
            }
            return;
        }
        dfs(idx + 1, num * 10 + (idx + 1), sum, op, express + " " + (idx + 1));
        dfs(idx + 1, idx + 1, sum + op * num, 1, express + "+" + (idx + 1));
        dfs(idx + 1, idx + 1, sum + op * num, -1, express + "-" + (idx + 1));
    }  
}
