import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main12919 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        dfs(S, T);
        System.out.println(answer);
    }

    static void dfs(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T)) {
                answer = 1;
                return;
            } else {
                return;
            }
        }
        if (T.charAt(T.length() - 1) == 'A') {
            dfs(S, T.substring(0, T.length() - 1));
        }
        if (T.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer();
            dfs(S, sb.append(T.substring(1)).reverse().toString());
        }
    }
}
