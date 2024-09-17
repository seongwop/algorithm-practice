import java.io.*;
import java.util.*;


public class main11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        
        for (int i = 0; i < T; i++) {
            long sum = 0;
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j] > max) max = arr[j];
                else sum += max - arr[j];
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}