import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(bf.readLine());
            if (n > 0) pq.offer(n);
            else if (n == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                int num = pq.poll();
                System.out.println(num);
            }
            
            
        }
    }
}