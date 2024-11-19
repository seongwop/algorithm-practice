import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        
        for (int i = 1; i < K - 1; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for (int j = i + 1; j < K; j++) {
                right = Math.max(right, arr[j]);
            }
            if (arr[i] < left && arr[i] < right) {
                total += Math.min(left, right) - arr[i];
            }
        }
        System.out.println(total);
    }
}
