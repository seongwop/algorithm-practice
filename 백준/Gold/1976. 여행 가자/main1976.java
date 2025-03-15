import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1976 {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
       
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (start != find(current)) {
                System.out.println("NO");
                return;
            } 
        }
        System.out.println("YES");   
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[x] = y;
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return find(parent[x]);
    }
}
