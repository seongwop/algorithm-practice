import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main14658 {
    static int N, M, L, K, answer;
    static ArrayList<Node> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   
        M = Integer.parseInt(st.nextToken());   
        L = Integer.parseInt(st.nextToken());   
        K = Integer.parseInt(st.nextToken());
        al = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al.add(new Node(x, y));
        }
        trampoline();
        System.out.println(K - answer);
    }

    static void trampoline() {
        for (Node a : al) {
            for (Node b : al) {
                int num = inbound(a.x, b.y, L);
                answer = Math.max(answer, num);
            }
        }
    }

    static int inbound(int x, int y, int l) {
        int cnt = 0;
        for (Node c : al) {
            if (c.x >= x && c.x <= x + l && c.y >= y && c.y <= y + l) cnt++;
        }
        return cnt;
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
