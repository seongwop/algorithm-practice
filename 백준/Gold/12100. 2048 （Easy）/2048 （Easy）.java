import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int answer = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int count, int[][] map) {
        if (count == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, map[i][j]);
                }
            }
            return;
        }
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(count + 1, map);
            for (int j = 0; j < N; j++) {
                map[j] = copy[j].clone();
            }
        }
    }

    static void move(int direction) {
        switch (direction) {
            case 0: // 왼쪽
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] != 0) {
                            if (map[i][j] == block) {
                                map[i][index - 1] = block * 2;
                                map[i][j] = 0;
                                block = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index++] = block;
                            }
                        }
                    }
                }
                break;
            case 1: // 오른쪽
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            if (map[i][j] == block) {
                                map[i][index + 1] = block * 2;
                                map[i][j] = 0;
                                block = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index--] = block;
                            }
                        }
                    }
                }
                break;
            case 2: // 위
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] != 0) {
                            if (map[j][i] == block) {
                                map[index - 1][i] = block * 2;
                                map[j][i] = 0;
                                block = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index++][i] = block;
                            }
                        }
                    }
                }
                break;
            case 3: // 아래
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[j][i] != 0) {
                            if (map[j][i] == block) {
                                map[index + 1][i] = block * 2;
                                map[j][i] = 0;
                                block = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index--][i] = block;
                            }
                        }
                    }
                }
                break;
        }
    }
}
