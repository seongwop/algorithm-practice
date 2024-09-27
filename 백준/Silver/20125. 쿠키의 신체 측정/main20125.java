import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main20125 {

    static int x = 0;
    static int y = 0;
    static int bx = 0;
    static int by = 0;
    static StringBuilder sb;
    static boolean[][] cookie;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenzier 쓰면 에러남(?)
        sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        cookie = new boolean[N + 2][N + 2];

        int left_arm = 0;
        int right_arm = 0;
        
        int left_leg = 0;
        int right_leg = 0;

        for (int i = 1; i <= N; i++) {
            String line = bf.readLine();
            for (int j = 1; j <= N; j++) {
                if (line.charAt(j - 1) == '*') {
                    cookie[i][j] = true;
                }
            }
        }
        
        find_heart(N);
        left_arm = find_length(0, -1, x, y);
        right_arm = find_length(0, 1, x, y);
        int body = find_length(1, 0, x, y);
        x = bx;
        y = by;
        left_leg = find_length(1, 0, x, y - 1) + 1;
        right_leg = find_length(1, 0, x, y + 1) + 1;
        sb.append(left_arm + " " + right_arm + " " + body + " " + left_leg + " " + right_leg);
        System.out.println(sb.toString());
        
    }

    static void find_heart(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cookie[i][j]) {
                    x = i + 1;
                    y = j;
                    sb.append(x + " " + y + "\n");
                    return;
                }
            }
        }
    }

    static int find_length(int dx, int dy, int x, int y) {
        int length = -1;
        while (true) {
            if (!cookie[x][y]) break;
            x += dx;
            y += dy;
            length++;
        }
        bx = x;
        by = y;
        return length;
    }
}

