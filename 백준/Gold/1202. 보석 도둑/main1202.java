import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main1202 {

    static class Jewelry {
        int M, V;
        public Jewelry(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.M == o2.M) return o2.V - o1.V;
                return o1.M - o2.M;
            }
        });
        Arrays.sort(bags);

        int idx = 0;
        for (int i = 0; i < K; i++) {
            while (idx < N && bags[i] >= jewelries[idx].M) {
                pq.add(jewelries[idx++].V);
            }
            if (!pq.isEmpty()) total += pq.poll();
        }
        System.out.println(total);
    }
}
