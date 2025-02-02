import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int length = Integer.MAX_VALUE, left = 0, right = 0, sum = 0;
        while (left <= N && right <= N) {
            if (sum >= S) {
                length = Math.min(length, right - left);
                sum -= arr[left++];
            } else {
                sum += arr[right++];
            }
        }
        if (length == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(length);
    }
}
