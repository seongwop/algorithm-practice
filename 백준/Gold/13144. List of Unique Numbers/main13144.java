import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main13144 {
    static int N;
    static int[] arr, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        cnt = new int[100000 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        twoPoint();    
    }
    static void twoPoint() {
        long answer = 0;
        int left = 1, right = 0;
        while (left <= N) {
            while (right + 1 <= N && cnt[arr[right + 1]] == 0) {
                right++;
                cnt[arr[right]]++;
            }
            answer += right - left + 1;
            cnt[arr[left++]]--;
        }
        System.out.println(answer);
    }
}
