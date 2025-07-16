import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main15683 {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[][] office;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N + 1][M + 1];
        ArrayList<Point> cctv = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0 && num!= 6) cctv.add(new Point(i, j, num));
                office[i][j] = num;
            }
        }
        bfs(0, office, cctv);
        System.out.println(min);
    }

    public static void bfs(int cnt, int[][] arr, ArrayList<Point> cctv) {
        if (cnt == cctv.size()) {
            min = Math.min(min, getZeros(arr));
            return;
        }
        int x = cctv.get(cnt).x;
        int y = cctv.get(cnt).y;
        int num = cctv.get(cnt).num;
        int[][] temp;
        if (num == 1) {
            temp = copyArray(arr);
            seeLeft(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeRight(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeDown(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeUp(x, y, temp);
            bfs(cnt + 1, temp, cctv);
        } else if (num == 2) {
            temp = copyArray(arr);
            seeLeft(x, y, temp);
            seeRight(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeUp(x, y, temp);
            seeDown(x, y, temp);
            bfs(cnt + 1, temp, cctv);
        } else if (num == 3) {
            temp = copyArray(arr);
            seeUp(x, y, temp);
            seeRight(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeRight(x, y, temp);
            seeDown(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeDown(x, y, temp);
            seeLeft(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeLeft(x, y, temp);
            seeUp(x, y, temp);
            bfs(cnt + 1, temp, cctv);
        } else if (num == 4) {
            temp = copyArray(arr);
            seeLeft(x, y, temp);
            seeUp(x, y, temp);
            seeRight(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeUp(x, y, temp);
            seeRight(x, y, temp);
            seeDown(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeRight(x, y, temp);
            seeDown(x, y, temp);
            seeLeft(x, y, temp);
            bfs(cnt + 1, temp, cctv);
            temp = copyArray(arr);
            seeDown(x, y, temp);
            seeLeft(x, y, temp);
            seeUp(x, y, temp);
            bfs(cnt + 1, temp, cctv);
        } else if (num == 5) {
            temp = copyArray(arr);
            seeUp(x, y, temp);
            seeRight(x, y, temp);
            seeDown(x, y, temp);
            seeLeft(x, y, temp);
            bfs(cnt + 1, temp, cctv);
        }
    }
    
    public static void seeLeft(int x, int y, int[][] arr) {
        for (int i = y - 1; i >= 1; i--) {
            if (arr[x][i] == 6) break;
            if (arr[x][i] != 0) continue;
            arr[x][i] = -1;
        }
    }

    public static void seeRight(int x, int y, int[][] arr) {
        for (int i = y + 1; i <= M; i++) {
            if (arr[x][i] == 6) break;
            if (arr[x][i] != 0) continue;
            arr[x][i] = -1;
        }
    }

    public static void seeUp(int x, int y, int[][] arr) {
        for (int i = x - 1; i >= 1; i--) {
            if (arr[i][y] == 6) break;
            if (arr[i][y] != 0) continue;
            arr[i][y] = -1;
        }
    }

    public static void seeDown(int x, int y, int[][] arr) {
        for (int i = x + 1; i <= N; i++) {
            if (arr[i][y] == 6) break;
            if (arr[i][y] != 0) continue;
            arr[i][y] = -1;
        }
    }

    public static int[][] copyArray(int[][] arr) {
        int[][] temp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    public static int getZeros(int[][] arr) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static class Point {
        int x;
        int y;
        int num;
        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    
}
