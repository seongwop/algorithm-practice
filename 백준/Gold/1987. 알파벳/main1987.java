import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1987 {
    static char[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int R, C;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int[] arr = new int[26];
        arr[board[0][0] - 'A']++;
        dfs(0, 0, 1, arr);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt, int[] arr) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && mx < R && my >= 0 && my < C) {
                if (arr[board[mx][my] - 'A'] == 0) {
                    arr[board[mx][my] - 'A']++;
                    dfs(mx, my, cnt + 1, arr);
                    arr[board[mx][my] - 'A']--;
                }
            }
        }
    } 
}
