import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main4179 {
    static char[][] maze;
    static int[][] mazeF, mazeJ;
    static int R, C;
    static int[] locJ;
    static ArrayList<int[]> locF = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R][C];
        mazeF = new int[R][C];
        mazeJ = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);
                mazeJ[i][j] = -1;
                if (maze[i][j] == 'J') locJ = new int[]{i, j};
                else if (maze[i][j] == 'F') locF.add(new int[]{i, j});
            }
        }
        mazeJ[locJ[0]][locJ[1]] = 0;
        if (!locF.isEmpty()) {
            bfsF();
            bfsJ(true);
        } else {
            bfsJ(false);
        }
        if (min != Integer.MAX_VALUE) System.out.println(min + 1);
        else System.out.println("IMPOSSIBLE");
    }

    public static void bfsF() {
        int[][] mazeF1 = new int[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] fire : locF) queue.offer(fire);
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cur = mazeF[loc[0]][loc[1]];
                int x = loc[0] + dx[i];
                int y = loc[1] + dy[i];
                if (x >= 0 && x < R && y >= 0 && y < C
                    && maze[x][y] != '#' && maze[x][y] != 'F' && mazeF[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        mazeF[x][y] = cur + 1;
                }
            }
        }
    }

    public static void bfsJ(boolean isFired) {
        if (locJ[0] == 0 || locJ[0] == R - 1 || locJ[1] == 0 || locJ[1] == C - 1) {
            min = 0;
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(locJ);
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cur = mazeJ[loc[0]][loc[1]];
                int x = loc[0] + dx[i];
                int y = loc[1] + dy[i];
                if (isFired) {
                    if (x >= 0 && x < R && y >= 0 && y < C
                    && maze[x][y] != '#' && maze[x][y] != 'F' && mazeJ[x][y] == -1) {
                        if (mazeF[x][y] == 0 || cur + 1 < mazeF[x][y]) {
                            queue.add(new int[]{x, y});
                            mazeJ[x][y] = cur + 1;
                            if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                                if (mazeJ[x][y] != -1) min = Math.min(min, mazeJ[x][y]);
                            }
                        }
                    }  
                } else {
                    if (x >= 0 && x < R && y >= 0 && y < C
                    && maze[x][y] != '#' && mazeJ[x][y] == -1) {
                        if (mazeF[x][y] == 0 || cur + 1 < mazeF[x][y]) {
                            queue.add(new int[]{x, y});
                            mazeJ[x][y] = cur + 1;    
                            if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                                if (mazeJ[x][y] != -1) min = Math.min(min, mazeJ[x][y]);
                            }
                        }
                    }     
                }  
            } 
        }
    }
}