import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main2110 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 1, right = arr[N - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            if (count(mid) < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    public static int count(int mid) {
        int prev = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev>= mid) {
                prev = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
